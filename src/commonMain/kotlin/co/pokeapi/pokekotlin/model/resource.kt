package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.HandleSerializers
import co.pokeapi.pokekotlin.internal.JsNonWasmExport
import kotlin.reflect.KClass
import kotlinx.serialization.Serializable

@Suppress("EnumEntryName")
internal enum class ResourceEndpoint(val model: KClass<out Model>) {
  ability(Ability::class),
  berry(Berry::class),
  `berry-firmness`(BerryFirmness::class),
  `berry-flavor`(BerryFlavor::class),
  characteristic(Characteristic::class),
  `contest-effect`(ContestEffect::class),
  `contest-type`(ContestType::class),
  `egg-group`(EggGroup::class),
  `encounter-condition`(EncounterCondition::class),
  `encounter-condition-value`(EncounterConditionValue::class),
  `encounter-method`(EncounterMethod::class),
  `evolution-chain`(EvolutionChain::class),
  `evolution-trigger`(EvolutionTrigger::class),
  gender(Gender::class),
  generation(Generation::class),
  `growth-rate`(GrowthRate::class),
  item(Item::class),
  `item-attribute`(ItemAttribute::class),
  `item-category`(ItemCategory::class),
  `item-fling-effect`(ItemFlingEffect::class),
  `item-pocket`(ItemPocket::class),
  language(Language::class),
  location(Location::class),
  `location-area`(LocationArea::class),
  machine(Machine::class),
  move(Move::class),
  `move-ailment`(MoveAilment::class),
  `move-battle-style`(MoveBattleStyle::class),
  `move-category`(MoveCategory::class),
  `move-damage-class`(MoveDamageClass::class),
  `move-learn-method`(MoveLearnMethod::class),
  `move-target`(MoveTarget::class),
  nature(Nature::class),
  `pal-park-area`(PalParkArea::class),
  `pokeathlon-stat`(PokeathlonStat::class),
  pokedex(Pokedex::class),
  pokemon(PokemonVariety::class),
  `pokemon-color`(PokemonColor::class),
  `pokemon-form`(PokemonForm::class),
  `pokemon-habitat`(PokemonHabitat::class),
  `pokemon-shape`(PokemonShape::class),
  `pokemon-species`(PokemonSpecies::class),
  region(Region::class),
  stat(Stat::class),
  `super-contest-effect`(SuperContestEffect::class),
  type(Type::class),
  version(Version::class),
  `version-group`(VersionGroup::class);

  companion object {
    private val modelToEntry = entries.associateBy { it.model }

    operator fun get(model: KClass<out Model>) =
      modelToEntry[model] ?: throw NoSuchElementException(model.simpleName)

    inline fun <reified T : Model> forModel() = get(T::class)
  }

  override fun toString() = name
}

/**
 * Represents a reference to a resource in the API by URL.
 *
 * @property id The identifier for the resource.
 */
@JsNonWasmExport
public sealed class Handle<out T : Model> {
  internal abstract val url: String

  internal val model: KClass<out T> by lazy {
    val match = urlRegex.find(url)?.groupValues[1] ?: throw IllegalArgumentException(url)
    @Suppress("UNCHECKED_CAST")
    ResourceEndpoint.valueOf(match).model as KClass<T>
  }

  public val id: Int by lazy {
    urlRegex.find(url)?.groupValues[2]?.toInt() ?: throw IllegalArgumentException(url)
  }

  internal companion object Companion {
    private val urlRegex = "/([a-z\\-]+)/(-?[0-9]+)/$".toRegex()

    internal inline fun <reified T : Model> of(id: Int): Unnamed<T> =
      Unnamed("/api/v2/${ResourceEndpoint.forModel<T>()}/$id/")

    internal inline fun <reified T : NamedModel> of(id: Int, name: String): Named<T> =
      Named("/api/v2/${ResourceEndpoint.forModel<T>()}/$id/", name)
  }

  /**
   * Represents a reference to another resource in the API by URL only. This matches the "resource"
   * object pattern in the PokeAPI documentation. See: https://pokeapi.co/docs/v2#apiresource
   */
  @Serializable(with = HandleSerializers.Unnamed::class)
  public data class Unnamed<out T : Model> internal constructor(override val url: String) :
    Handle<T>()

  /**
   * Represents a reference to another resource in the API by name and URL. This matches the "named
   * resource" object pattern in the PokeAPI documentation. See:
   * https://pokeapi.co/docs/v2#namedapiresource
   *
   * @param name The (unique) name of the referenced resource.
   */
  @Serializable(with = HandleSerializers.Named::class)
  public data class Named<out T : NamedModel>
  internal constructor(override val url: String, val name: String) : Handle<T>()
}

/**
 * Represents a paginated list of [Handle], similar to the paginated resource list objects in the
 * PokeAPI. See: https://pokeapi.co/docs/v2#resource-listspagination-section
 *
 * @property count The total number of resources available from this API.
 * @property next The URL for the next page in the list.
 * @property previous The URL for the previous page in the list.
 * @property results The list of returned resources in this page.
 */
@JsNonWasmExport
public sealed class PaginatedList<out T : Model> {
  public abstract val count: Int
  public abstract val next: String?
  public abstract val previous: String?
  public abstract val results: List<Handle<T>>

  @Serializable
  public data class Unnamed<out T : Model>
  internal constructor(
    override val count: Int,
    override val next: String?,
    override val previous: String?,
    override val results: List<Handle.Unnamed<T>>,
  ) : PaginatedList<T>()

  @Serializable
  public data class Named<out T : NamedModel>
  internal constructor(
    override val count: Int,
    override val next: String?,
    override val previous: String?,
    override val results: List<Handle.Named<T>>,
  ) : PaginatedList<T>()
}
