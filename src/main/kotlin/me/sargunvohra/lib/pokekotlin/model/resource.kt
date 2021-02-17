package me.sargunvohra.lib.pokekotlin.model

private fun urlToId(url: String): Int {
    return "/-?[0-9]+/$".toRegex().find(url)!!.value.filter { it.isDigit() || it == '-' }.toInt()
}

private fun urlToCat(url: String): String {
    return "/[a-z\\-]+/-?[0-9]+/$".toRegex().find(url)!!.value.filter { it.isLetter() || it == '-' }
}

private fun resourceUrl(id: Int, category: String): String {
    return "/api/v2/$category/$id/"
}

interface ResourceSummary {
    val id: Int
    val category: String
}

data class ApiResource(
    val url: String
) : ResourceSummary {
    constructor(category: String, id: Int) : this(resourceUrl(id, category))

    override val category by lazy { urlToCat(url) }
    override val id by lazy { urlToId(url) }
}

data class NamedApiResource(
    val name: String,
    val url: String
) : ResourceSummary {
    constructor(name: String, category: String, id: Int) : this(name, resourceUrl(id, category))

    override val category by lazy { urlToCat(url) }
    override val id by lazy { urlToId(url) }
}

interface ResourceSummaryList<out T : ResourceSummary> {
    val count: Int
    val next: String?
    val previous: String?
    val results: List<T>
}

data class ApiResourceList(
    override val count: Int,
    override val next: String?,
    override val previous: String?,
    override val results: List<ApiResource>
) : ResourceSummaryList<ApiResource>

data class NamedApiResourceList(
    override val count: Int,
    override val next: String?,
    override val previous: String?,
    override val results: List<NamedApiResource>
) : ResourceSummaryList<NamedApiResource>
