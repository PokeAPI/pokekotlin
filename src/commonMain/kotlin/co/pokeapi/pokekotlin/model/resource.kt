package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.ApiResourceSerializer
import co.pokeapi.pokekotlin.internal.JsOnlyExport
import co.pokeapi.pokekotlin.internal.NamedApiResourceSerializer
import kotlin.js.JsName
import kotlinx.serialization.Serializable

private fun urlToId(url: String): Int {
  return "/-?[0-9]+/$".toRegex().find(url)!!.value.filter { it.isDigit() || it == '-' }.toInt()
}

private fun urlToCat(url: String): String {
  return "/[a-z\\-]+/-?[0-9]+/$".toRegex().find(url)!!.value.filter { it.isLetter() || it == '-' }
}

private fun resourceUrl(id: Int, category: String): String {
  return "/api/v2/$category/$id/"
}

/**
 * Represents a summary of a resource, providing its id and category.
 *
 * @property id The identifier for the resource.
 * @property category The resource category (endpoint name).
 */
@JsOnlyExport
public interface ResourceSummary {
  public val id: Int
  public val category: String
}

/**
 * Represents a reference to another resource in the API by URL. This matches the "resource" object
 * pattern in the PokeAPI documentation. See:
 * https://pokeapi.co/docs/v2#resource-listspagination-section
 *
 * @param url The URL of the referenced resource.
 */
@Serializable(with = ApiResourceSerializer::class)
@JsOnlyExport
public data class ApiResource(val url: String) : ResourceSummary {
  @JsName("create") public constructor(category: String, id: Int) : this(resourceUrl(id, category))

  override val category: String by lazy { urlToCat(url) }
  override val id: Int by lazy { urlToId(url) }
}

/**
 * Represents a reference to another resource in the API by name and URL. This matches the "named
 * resource" object pattern in the PokeAPI documentation. See:
 * https://pokeapi.co/docs/v2#resource-listspagination-section
 *
 * @param name The name of the referenced resource.
 * @param url The URL of the referenced resource.
 */
@Serializable(with = NamedApiResourceSerializer::class)
@JsOnlyExport
public data class NamedApiResource(val name: String, val url: String) : ResourceSummary {

  @JsName("create")
  public constructor(
    name: String,
    category: String,
    id: Int,
  ) : this(name, resourceUrl(id, category))

  override val category: String by lazy { urlToCat(url) }
  override val id: Int by lazy { urlToId(url) }
}

/**
 * Represents a paginated list of resource summaries, similar to the paginated resource list objects
 * in the PokeAPI. See: https://pokeapi.co/docs/v2#resource-lists-section
 *
 * @property count The total number of resources available from this API.
 * @property next The URL for the next page in the list.
 * @property previous The URL for the previous page in the list.
 * @property results The list of returned resources in this page.
 */
@JsOnlyExport
public interface ResourceSummaryList<out T : ResourceSummary> {
  public val count: Int
  public val next: String?
  public val previous: String?
  public val results: List<T>
}

@Serializable
@JsOnlyExport
public data class ApiResourceList(
  override val count: Int,
  override val next: String?,
  override val previous: String?,
  override val results: List<ApiResource>,
) : ResourceSummaryList<ApiResource>

@Serializable
@JsOnlyExport
public data class NamedApiResourceList(
  override val count: Int,
  override val next: String?,
  override val previous: String?,
  override val results: List<NamedApiResource>,
) : ResourceSummaryList<NamedApiResource>
