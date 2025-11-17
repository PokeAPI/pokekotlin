package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsNonWasmExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Abilities provide passive effects for Pokémon in battle or in the overworld. Pokémon have
 * multiple possible abilities but only one ability on each individual Pokémon. See:
 * https://pokeapi.co/docs/v2#abilities
 *
 * @param id The identifier for this ability resource.
 * @param name The name for this ability resource.
 * @param isMainSeries Whether or not this ability originated in the main series of the video games.
 * @param generation The generation this ability was introduced in.
 * @param names The name of this ability listed in different languages.
 * @param effectEntries The effect of this ability listed in different languages.
 * @param effectChanges The list of past effects this ability has had across version groups.
 * @param flavorTextEntries The flavor text of this ability listed in different languages.
 * @param pokemon A list of Pokémon that could potentially have this ability.
 */
@Serializable
@JsNonWasmExport
public data class Ability(
  override val id: Int,
  override val name: String,
  val isMainSeries: Boolean,
  val generation: Handle.Named<Generation>,
  val names: List<Name>,
  val effectEntries: List<VerboseEffect>,
  val effectChanges: List<AbilityEffectChange>,
  val flavorTextEntries: List<AbilityFlavorText>,
  val pokemon: List<AbilityPokemon>,
) : NamedModel

/**
 * The effect of an ability listed in different version groups and languages. See:
 * https://pokeapi.co/docs/v2#abilityeffectchange
 *
 * @param effectEntries The effect text entries for this ability and version group.
 * @param versionGroup The version group for which the effect applies.
 */
@Serializable
@JsNonWasmExport
public data class AbilityEffectChange(
  val effectEntries: List<Effect>,
  val versionGroup: Handle.Named<VersionGroup>,
)

/**
 * The flavor text of an ability listed in different languages and version groups. See:
 * https://pokeapi.co/docs/v2#abilityflavortext
 *
 * @param flavorText The localized flavor text for an ability.
 * @param language The language this flavor text is in.
 * @param versionGroup The version group for which the flavor text applies.
 */
@Serializable
@JsNonWasmExport
public data class AbilityFlavorText(
  val flavorText: String,
  val language: Handle.Named<Language>,
  val versionGroup: Handle.Named<VersionGroup>,
)

/**
 * Pokémon that could potentially have this ability. See: https://pokeapi.co/docs/v2#abilitypokemon
 *
 * @param isHidden Whether or not this is a hidden ability for the referenced Pokémon.
 * @param slot The slot this ability occupies for the referenced Pokémon.
 * @param pokemon The Pokémon that has the referenced ability.
 */
@Serializable
@JsNonWasmExport
public data class AbilityPokemon(
  val isHidden: Boolean,
  val slot: Int,
  val pokemon: Handle.Named<PokemonVariety>,
)

/**
 * Characteristics help determine which stats are likely to be the highest for a Pokémon. See:
 * https://pokeapi.co/docs/v2#characteristics
 *
 * @param id The identifier for this characteristic resource.
 * @param geneModulo The remainder of the highest stat's IV divided by 5.
 * @param possibleValues A list of possible values for the highest stat.
 * @param descriptions The descriptions for this characteristic listed in different languages.
 */
@Serializable
@JsNonWasmExport
public data class Characteristic(
  override val id: Int,
  val geneModulo: Int,
  val possibleValues: List<Int>,
  val descriptions: List<Description>,
) : Model

/**
 * Egg Groups are categories which determine which Pokémon are able to interbreed. See:
 * https://pokeapi.co/docs/v2#egggroups
 *
 * @param id The identifier for this egg group resource.
 * @param name The name for this egg group resource.
 * @param names The name of this egg group listed in different languages.
 * @param pokemonSpecies A list of all Pokémon species that are members of this egg group.
 */
@Serializable
@JsNonWasmExport
public data class EggGroup(
  override val id: Int,
  override val name: String,
  val names: List<Name>,
  val pokemonSpecies: List<Handle.Named<PokemonSpecies>>,
) : NamedModel

/**
 * Genders affect whether a Pokémon can breed and what moves it can learn. See:
 * https://pokeapi.co/docs/v2#genders
 *
 * @param id The identifier for this gender resource.
 * @param name The name for this gender resource.
 * @param pokemonSpeciesDetails A list of Pokémon species that can be this gender and how likely it
 *   is that they will be.
 * @param requiredForEvolution A list of Pokémon species that require this gender in order for a
 *   Pokémon to evolve into them.
 */
@Serializable
@JsNonWasmExport
public data class Gender(
  override val id: Int,
  override val name: String,
  val pokemonSpeciesDetails: List<PokemonSpeciesGender>,
  val requiredForEvolution: List<Handle.Named<PokemonSpecies>>,
) : NamedModel

/**
 * Pokémon species gender details. See: https://pokeapi.co/docs/v2#pokemonspeciesgender
 *
 * @param rate The chance of this Pokémon being female, in eighths; or -1 for genderless.
 * @param pokemonSpecies The Pokémon species this gender detail applies to.
 */
@Serializable
@JsNonWasmExport
public data class PokemonSpeciesGender(
  val rate: Int,
  val pokemonSpecies: Handle.Named<PokemonSpecies>,
)

/**
 * Growth rates determine how much experience Pokémon need to level up. See:
 * https://pokeapi.co/docs/v2#growthrates
 *
 * @param id The identifier for this growth rate resource.
 * @param name The name for this growth rate resource.
 * @param formula The formula used to calculate the rate at which the Pokémon levels up.
 * @param descriptions The descriptions for this growth rate listed in different languages.
 * @param levels A list of levels and the experience needed to reach them.
 * @param pokemonSpecies A list of Pokémon species that have this growth rate.
 */
@Serializable
@JsNonWasmExport
public data class GrowthRate(
  override val id: Int,
  override val name: String,
  val formula: String,
  val descriptions: List<Description>,
  val levels: List<GrowthRateExperienceLevel>,
  val pokemonSpecies: List<Handle.Named<PokemonSpecies>>,
) : NamedModel

/**
 * Experience required for a Pokémon to reach a certain level for a given growth rate. See:
 * https://pokeapi.co/docs/v2#growthrateexperiencelevel
 *
 * @param level The level gained.
 * @param experience The amount of experience required to reach the referenced level.
 */
@Serializable
@JsNonWasmExport
public data class GrowthRateExperienceLevel(val level: Int, val experience: Int)

/**
 * Natures influence how a Pokémon's stats grow. See: https://pokeapi.co/docs/v2#natures
 *
 * @param id The identifier for this nature resource.
 * @param name The name for this nature resource.
 * @param decreasedStat The stat decreased by 10% in Pokémon with this nature.
 * @param increasedStat The stat increased by 10% in Pokémon with this nature.
 * @param hatesFlavor The flavor hated by Pokémon with this nature.
 * @param likesFlavor The flavor liked by Pokémon with this nature.
 * @param pokeathlonStatChanges A list of changes to Pokeathlon stats for Pokémon with this nature.
 * @param moveBattleStylePreferences A list of battle style preferences for Pokémon with this
 *   nature.
 * @param names The name of this nature listed in different languages.
 */
@Serializable
@JsNonWasmExport
public data class Nature(
  override val id: Int,
  override val name: String,
  val decreasedStat: Handle.Named<Stat>?,
  val increasedStat: Handle.Named<Stat>?,
  val hatesFlavor: Handle.Named<BerryFlavor>?,
  val likesFlavor: Handle.Named<BerryFlavor>?,
  val pokeathlonStatChanges: List<NatureStatChange>,
  val moveBattleStylePreferences: List<MoveBattleStylePreference>,
  val names: List<Name>,
) : NamedModel

/**
 * Change to a Pokeathlon stat for a given nature. See: https://pokeapi.co/docs/v2#naturestatchange
 *
 * @param maxChange The maximum amount of change to the referenced Pokeathlon stat.
 * @param pokeathlonStat The Pokeathlon stat being affected.
 */
@Serializable
@JsNonWasmExport
public data class NatureStatChange(
  val maxChange: Int,
  val pokeathlonStat: Handle.Named<PokeathlonStat>,
)

/**
 * Move battle style preferences for a given nature. See:
 * https://pokeapi.co/docs/v2#movebattlestylepreference
 *
 * @param lowHpPreference Chance of using the move style when HP is low.
 * @param highHpPreference Chance of using the move style when HP is high.
 * @param moveBattleStyle The move battle style.
 */
@Serializable
@JsNonWasmExport
public data class MoveBattleStylePreference(
  val lowHpPreference: Int,
  val highHpPreference: Int,
  val moveBattleStyle: Handle.Named<MoveBattleStyle>,
)

/**
 * Pokeathlon stats are different qualities a Pokémon can have in the Pokeathlon competitions. See:
 * https://pokeapi.co/docs/v2#pokeathlonstat
 *
 * @param id The identifier for this Pokeathlon stat resource.
 * @param name The name for this Pokeathlon stat resource.
 * @param names The name of this Pokeathlon stat listed in different languages.
 * @param affectingNatures A set of natures and how they affect this Pokeathlon stat.
 */
@Serializable
@JsNonWasmExport
public data class PokeathlonStat(
  override val id: Int,
  override val name: String,
  val names: List<Name>,
  val affectingNatures: NaturePokeathlonStatEffectSets,
) : NamedModel

/**
 * A set of natures and how they affect a Pokeathlon stat. See:
 * https://pokeapi.co/docs/v2#naturepokeathlonstataffectsets
 *
 * @param increase Natures that increase the referenced Pokeathlon stat and by how much.
 * @param decrease Natures that decrease the referenced Pokeathlon stat and by how much.
 */
@Serializable
@JsNonWasmExport
public data class NaturePokeathlonStatEffectSets(
  val increase: List<NaturePokeathlonStatEffect>,
  val decrease: List<NaturePokeathlonStatEffect>,
)

/**
 * Nature and the amount it affects a Pokeathlon stat. See:
 * https://pokeapi.co/docs/v2#naturepokeathlonstataffect
 *
 * @param maxChange The maximum amount of change to the referenced Pokeathlon stat.
 * @param nature The nature that affects the referenced Pokeathlon stat.
 */
@Serializable
@JsNonWasmExport
public data class NaturePokeathlonStatEffect(val maxChange: Int, val nature: Handle.Named<Nature>)

/**
 * Pokémon are the creatures that inhabit the world of the Pokémon games. They have a variety of
 * stats, abilities, and forms. See: https://pokeapi.co/docs/v2#pokemon
 *
 * @param id The identifier for this Pokémon resource.
 * @param name The name for this Pokémon resource.
 * @param baseExperience The base experience gained for defeating this Pokémon.
 * @param height The height of this Pokémon in decimetres.
 * @param isDefault Whether this is the default variety of the Pokémon.
 * @param order The order for sorting. Almost national order, except families are grouped together.
 * @param weight The weight of this Pokémon in hectograms.
 * @param species The species this Pokémon belongs to.
 * @param abilities A list of abilities this Pokémon could potentially have.
 * @param forms A list of forms this Pokémon can take.
 * @param gameIndices A list of game indices relevant to this Pokémon.
 * @param heldItems A list of items this Pokémon may be holding when encountered.
 * @param moves A list of moves this Pokémon can learn.
 * @param stats A list of base stat values for this Pokémon.
 * @param types A list of types this Pokémon has.
 * @param pastTypes A list of types this Pokémon had in previous generations.
 * @param pastAbilities A list of abilities this Pokémon had in previous generations.
 * @param cries The cries for this Pokémon.
 * @param sprites A set of sprites used to depict this Pokémon in the game.
 */
@Serializable
@JsNonWasmExport
public data class PokemonVariety(
  override val id: Int,
  override val name: String,
  val baseExperience: Int,
  val height: Int,
  val isDefault: Boolean,
  val order: Int,
  val weight: Int,
  val species: Handle.Named<PokemonSpecies>,
  val abilities: List<PokemonAbility>,
  val forms: List<Handle.Named<PokemonForm>>,
  val gameIndices: List<VersionGameIndex>,
  val heldItems: List<PokemonHeldItem>,
  val moves: List<PokemonMove>,
  val stats: List<PokemonStat>,
  val types: List<PokemonType>,
  val pastTypes: List<PokemonPastType>,
  val pastAbilities: List<PokemonPastAbility>,
  val cries: PokemonCries,
  val sprites: PokemonSprites,
) : NamedModel

/**
 * Sprites are images used to depict Pokémon in the game. See:
 * https://pokeapi.co/docs/v2#pokemonsprites
 *
 * @param backDefault The default back sprite for this Pokémon.
 * @param backShiny The shiny back sprite for this Pokémon.
 * @param frontDefault The default front sprite for this Pokémon.
 * @param frontShiny The shiny front sprite for this Pokémon.
 * @param backFemale The female back sprite for this Pokémon.
 * @param backShinyFemale The female shiny back sprite for this Pokémon.
 * @param frontFemale The female front sprite for this Pokémon.
 * @param frontShinyFemale The female shiny front sprite for this Pokémon.
 * @param other Other sprites for this Pokémon.
 * @param versions Sprites for this Pokémon in different versions.
 */
@Serializable
@JsNonWasmExport
public data class PokemonSprites(
  val backDefault: String?,
  val backShiny: String?,
  val frontDefault: String?,
  val frontShiny: String?,
  val backFemale: String?,
  val backShinyFemale: String?,
  val frontFemale: String?,
  val frontShinyFemale: String?,
  val other: OtherGameSprites,
  val versions: VersionGameSprites,
)

/**
 * Other sprites for a Pokémon, such as Dream World and official artwork. See:
 * https://pokeapi.co/docs/v2#pokemonsprites
 *
 * @param dreamWorld Dream World sprites.
 * @param home Home sprites.
 * @param officialArtwork Official artwork sprites.
 * @param showdown Showdown sprites.
 */
@Serializable
@JsNonWasmExport
public data class OtherGameSprites(
  val dreamWorld: GameSprites,
  val home: GameSprites,
  @SerialName("official-artwork") val officialArtwork: GameSprites,
  val showdown: GameSprites,
)

/**
 * Sprites for a Pokémon in different game versions. See: https://pokeapi.co/docs/v2#pokemonsprites
 *
 * @param generationI Sprites for Generation I games.
 * @param generationIi Sprites for Generation II games.
 * @param generationIii Sprites for Generation III games.
 * @param generationIv Sprites for Generation IV games.
 * @param generationV Sprites for Generation V games.
 * @param generationVi Sprites for Generation VI games.
 * @param generationVii Sprites for Generation VII games.
 * @param generationViii Sprites for Generation VIII games.
 */
@Serializable
@JsNonWasmExport
public data class VersionGameSprites(
  @SerialName("generation-i") val generationI: GenerationIGameSprites,
  @SerialName("generation-ii") val generationIi: GenerationIiGameSprites,
  @SerialName("generation-iii") val generationIii: GenerationIiiGameSprites,
  @SerialName("generation-iv") val generationIv: GenerationIvGameSprites,
  @SerialName("generation-v") val generationV: GenerationVGameSprites,
  @SerialName("generation-vi") val generationVi: GenerationViGameSprites,
  @SerialName("generation-vii") val generationVii: GenerationViiGameSprites,
  @SerialName("generation-viii") val generationViii: GenerationViiiGameSprites,
)

@Serializable
@JsNonWasmExport
public data class GenerationIGameSprites(
  @SerialName("red-blue") val redBlue: GameSprites,
  val yellow: GameSprites,
)

@Serializable
@JsNonWasmExport
public data class GenerationIiGameSprites(
  val crystal: GameSprites,
  val gold: GameSprites,
  val silver: GameSprites,
)

@Serializable
@JsNonWasmExport
public data class GenerationIiiGameSprites(
  val emerald: GameSprites,
  @SerialName("firered-leafgreen") val fireredLeafgreen: GameSprites,
  @SerialName("ruby-sapphire") val rubySapphire: GameSprites,
)

@Serializable
@JsNonWasmExport
public data class GenerationIvGameSprites(
  @SerialName("diamond-pearl") val diamondPearl: GameSprites,
  @SerialName("heartgold-soulsilver") val heartgoldSoulsilver: GameSprites,
  val platinum: GameSprites,
)

@Serializable
@JsNonWasmExport
public data class GenerationVGameSprites(
  @SerialName("black-white") val blackWhite: BlackWhiteSprites
)

@Serializable
@JsNonWasmExport
public data class BlackWhiteSprites(
  val animated: GameSprites,
  val backDefault: String? = null,
  val backFemale: String? = null,
  val backShiny: String? = null,
  val backShinyFemale: String? = null,
  val frontDefault: String? = null,
  val frontFemale: String? = null,
  val frontShiny: String? = null,
  val frontShinyFemale: String? = null,
)

@Serializable
@JsNonWasmExport
public data class GenerationViGameSprites(
  @SerialName("omegaruby-alphasapphire") val omegaRubyAlphaSapphire: GameSprites,
  @SerialName("x-y") val xY: GameSprites,
)

@Serializable
@JsNonWasmExport
public data class GenerationViiGameSprites(
  val icons: GameSprites,
  @SerialName("ultra-sun-ultra-moon") val ultraSunUltraMoon: GameSprites,
)

@Serializable @JsNonWasmExport public data class GenerationViiiGameSprites(val icons: GameSprites)

/**
 * All available sprites for a Pokémon in a specific game or context. Each game will only have a
 * subset of these sprites present. See: https://pokeapi.co/docs/v2#pokemonsprites
 */
@Serializable
@JsNonWasmExport
public data class GameSprites(
  val animated: GameSprites? = null,
  val backDefault: String? = null,
  val backGray: String? = null,
  val backTransparent: String? = null,
  val backFemale: String? = null,
  val backShiny: String? = null,
  val backShinyTransparent: String? = null,
  val backShinyFemale: String? = null,
  val frontDefault: String? = null,
  val frontGray: String? = null,
  val frontTransparent: String? = null,
  val frontFemale: String? = null,
  val frontShiny: String? = null,
  val frontShinyTransparent: String? = null,
  val frontShinyFemale: String? = null,
)

/**
 * Details about a Pokémon's ability, including whether it is hidden and its slot. See:
 * https://pokeapi.co/docs/v2#pokemonability
 *
 * @param isHidden Whether or not this is a hidden ability.
 * @param slot The slot this ability occupies for the Pokémon.
 * @param ability The ability the Pokémon may have.
 */
@Serializable
@JsNonWasmExport
public data class PokemonAbility(
  val isHidden: Boolean,
  val slot: Int,
  val ability: Handle.Named<Ability>?,
)

/**
 * Items that a Pokémon may be holding when encountered. See:
 * https://pokeapi.co/docs/v2#pokemonhelditem
 *
 * @param item The item the Pokémon may be holding.
 * @param versionDetails The details of the version in which the item is held.
 */
@Serializable
@JsNonWasmExport
public data class PokemonHeldItem(
  val item: Handle.Named<Item>,
  val versionDetails: List<PokemonHeldItemVersion>,
)

/**
 * The details of the version in which a Pokémon may be holding an item. See:
 * https://pokeapi.co/docs/v2#pokemonhelditemversion
 *
 * @param version The version in which the item is held.
 * @param rarity The rarity of the held item in the version.
 */
@Serializable
@JsNonWasmExport
public data class PokemonHeldItemVersion(val version: Handle.Named<Version>, val rarity: Int)

/**
 * Moves that a Pokémon can learn. See: https://pokeapi.co/docs/v2#pokemonmove
 *
 * @param move The move the Pokémon can learn.
 * @param versionGroupDetails The details of the version group in which the move can be learned.
 */
@Serializable
@JsNonWasmExport
public data class PokemonMove(
  val move: Handle.Named<Move>,
  val versionGroupDetails: List<PokemonMoveVersion>,
)

/**
 * Details about how a Pokémon can learn a move in a specific version group. See:
 * https://pokeapi.co/docs/v2#pokemonmoveversion
 *
 * @param moveLearnMethod The method by which the Pokémon can learn the move.
 * @param versionGroup The version group in which the move can be learned.
 * @param levelLearnedAt The level at which the Pokémon learns the move, if applicable.
 * @param order The order in which the move is learned, if applicable.
 */
@Serializable
@JsNonWasmExport
public data class PokemonMoveVersion(
  val moveLearnMethod: Handle.Named<MoveLearnMethod>,
  val versionGroup: Handle.Named<VersionGroup>,
  val levelLearnedAt: Int,
  val order: Int?,
)

/**
 * Base stats for a Pokémon. See: https://pokeapi.co/docs/v2#pokemonstat
 *
 * @param stat The stat the value applies to.
 * @param effort The effort points (EVs) provided by this Pokémon for the stat.
 * @param baseStat The base value of the stat.
 */
@Serializable
@JsNonWasmExport
public data class PokemonStat(val stat: Handle.Named<Stat>, val effort: Int, val baseStat: Int)

/**
 * The type of a Pokémon and its slot. See: https://pokeapi.co/docs/v2#pokemontype
 *
 * @param slot The order the Pokémon's types are listed in.
 * @param type The type the Pokémon has.
 */
@Serializable
@JsNonWasmExport
public data class PokemonType(val slot: Int, val type: Handle.Named<Type>)

/**
 * The types a Pokémon had in a previous generation. See: https://pokeapi.co/docs/v2#pokemonpasttype
 *
 * @param generation The generation in which the Pokémon had the listed types.
 * @param types The types the Pokémon had in that generation.
 */
@Serializable
@JsNonWasmExport
public data class PokemonPastType(
  val generation: Handle.Named<Generation>,
  val types: List<PokemonType>,
)

/**
 * The abilities a Pokémon had in a previous generation. See:
 * https://pokeapi.co/docs/v2#pokemonpastability
 *
 * @param generation The generation in which the Pokémon had the listed abilities.
 * @param abilities The abilities the Pokémon had in that generation.
 */
@Serializable
@JsNonWasmExport
public data class PokemonPastAbility(
  val generation: Handle.Named<Generation>,
  val abilities: List<PokemonAbility>,
)

/**
 * The cries for a Pokémon. See: https://pokeapi.co/docs/v2#pokemoncries
 *
 * @param latest The latest cry for this Pokémon.
 * @param legacy The legacy cry for this Pokémon, if any.
 */
@Serializable
@JsNonWasmExport
public data class PokemonCries(val latest: String, val legacy: String?)

/**
 * Details about a Pokémon's encounters in a location area. See:
 * https://pokeapi.co/docs/v2#locationareaencounter
 *
 * @param locationArea The location area where the Pokémon can be encountered.
 * @param versionDetails The details of the encounter in each version.
 */
@Serializable
@JsNonWasmExport
public data class LocationAreaEncounter(
  val locationArea: Handle.Named<LocationArea>,
  val versionDetails: List<VersionEncounterDetail>,
)

/**
 * Colors are used for categorizing Pokémon for search purposes. See:
 * https://pokeapi.co/docs/v2#pokemoncolor
 *
 * @param id The identifier for this Pokémon color resource.
 * @param name The name for this Pokémon color resource.
 * @param names The name of this Pokémon color listed in different languages.
 * @param pokemonSpecies A list of the Pokémon species that have this color.
 */
@Serializable
@JsNonWasmExport
public data class PokemonColor(
  override val id: Int,
  override val name: String,
  val names: List<Name>,
  val pokemonSpecies: List<Handle.Named<PokemonSpecies>>,
) : NamedModel

/**
 * Some Pokémon may appear in one of multiple, visually different forms. These differences are
 * purely cosmetic. For variations within a Pokémon species, which do differ in more than just
 * visuals, the 'Pokémon' entity is used to represent such a variety. See:
 * https://pokeapi.co/docs/v2#pokemonform
 *
 * @param id The identifier for this form resource.
 * @param name The name for this form resource.
 * @param order The order in which forms should be sorted within all forms.
 * @param formOrder The order in which forms should be sorted within a species' forms.
 * @param isDefault True if this form is the default form for the Pokémon.
 * @param isBattleOnly Whether or not this form can only happen during battle.
 * @param isMega Whether or not this form is a mega form.
 * @param formName The name of this form.
 * @param pokemon The Pokémon that can take on this form.
 * @param types The form specific type of this Pokémon form.
 * @param sprites A set of sprites used to depict this Pokémon form in the game.
 * @param versionGroup The version group this Pokémon form was introduced in.
 * @param names The form specific form name of this Pokémon form, or empty if the form does not have
 *   a specific name.
 * @param formNames The form specific form name of this Pokémon form, or empty if the form does not
 *   have a specific name.
 */
@Serializable
@JsNonWasmExport
public data class PokemonForm(
  override val id: Int,
  override val name: String,
  val order: Int,
  val formOrder: Int,
  val isDefault: Boolean,
  val isBattleOnly: Boolean,
  val isMega: Boolean,
  val formName: String,
  val pokemon: Handle.Named<PokemonVariety>,
  val types: List<PokemonType>,
  val sprites: PokemonFormSprites,
  val versionGroup: Handle.Named<VersionGroup>,
  val names: List<Name>,
  val formNames: List<Name>,
) : NamedModel

/**
 * Sprites used to depict a Pokémon form. See: https://pokeapi.co/docs/v2#pokemonformsprites
 *
 * @param backDefault The default back sprite for this Pokémon form.
 * @param backFemale The female back sprite for this Pokémon form.
 * @param backShiny The shiny back sprite for this Pokémon form.
 * @param backShinyFemale The female shiny back sprite for this Pokémon form.
 * @param frontDefault The default front sprite for this Pokémon form.
 * @param frontFemale The female front sprite for this Pokémon form.
 * @param frontShiny The shiny front sprite for this Pokémon form.
 * @param frontShinyFemale The female shiny front sprite for this Pokémon form.
 */
@Serializable
@JsNonWasmExport
public data class PokemonFormSprites(
  val backDefault: String?,
  val backFemale: String?,
  val backShiny: String?,
  val backShinyFemale: String?,
  val frontDefault: String?,
  val frontFemale: String?,
  val frontShiny: String?,
  val frontShinyFemale: String?,
)

/**
 * Habitats are generally different terrain Pokémon can be found in but can also be structures like
 * buildings. See: https://pokeapi.co/docs/v2#pokemonhabitat
 *
 * @param id The identifier for this Pokémon habitat resource.
 * @param name The name for this Pokémon habitat resource.
 * @param names The name of this Pokémon habitat listed in different languages.
 * @param pokemonSpecies A list of the Pokémon species that can be found in this habitat.
 */
@Serializable
@JsNonWasmExport
public data class PokemonHabitat(
  override val id: Int,
  override val name: String,
  val names: List<Name>,
  val pokemonSpecies: List<Handle.Named<PokemonSpecies>>,
) : NamedModel

/**
 * Shapes are used to determine a Pokémon's appearance and for search purposes. See:
 * https://pokeapi.co/docs/v2#pokemonshape
 *
 * @param id The identifier for this Pokémon shape resource.
 * @param name The name for this Pokémon shape resource.
 * @param awesomeNames The "scientific" name of this Pokémon shape listed in different languages.
 * @param names The name of this Pokémon shape listed in different languages.
 * @param pokemonSpecies A list of the Pokémon species that have this shape.
 */
@Serializable
@JsNonWasmExport
public data class PokemonShape(
  override val id: Int,
  override val name: String,
  val awesomeNames: List<AwesomeName>,
  val names: List<Name>,
  val pokemonSpecies: List<Handle.Named<PokemonSpecies>>,
) : NamedModel

/**
 * The "scientific" name of a Pokémon shape. See: https://pokeapi.co/docs/v2#awesomename
 *
 * @param awesomeName The localized "scientific" name for a Pokémon shape.
 * @param language The language this "scientific" name is in.
 */
@Serializable
@JsNonWasmExport
public data class AwesomeName(val awesomeName: String, val language: Handle.Named<Language>)

/**
 * A Pokémon Species forms the basis for at least one Pokémon. Attributes of a Pokémon species are
 * shared across all varieties of Pokémon within the species. A good example is Wormadam; Wormadam
 * is the species which can be found in three different varieties, Wormadam-Trash, Wormadam-Sandy
 * and Wormadam-Plant. See: https://pokeapi.co/docs/v2#pokemonspecies
 *
 * @param id The identifier for this Pokémon species resource.
 * @param name The name for this Pokémon species resource.
 * @param order The order in which species should be sorted.
 * @param genderRate The chance of this Pokémon being female, in eighths; or -1 for genderless.
 * @param captureRate The base capture rate; up to 255.
 * @param baseHappiness The base happiness when caught by a normal Pokéball; up to 255.
 * @param isBaby Whether or not this is a baby Pokémon.
 * @param isLegendary Whether or not this is a legendary Pokémon.
 * @param isMythical Whether or not this is a mythical Pokémon.
 * @param hatchCounter Initial hatch counter: one must walk 255 × (hatch_counter + 1) steps before
 *   this Pokémon's egg hatches, unless utilizing bonuses like Flame Body's.
 * @param hasGenderDifferences Whether or not this Pokémon has visual gender differences.
 * @param formsSwitchable Whether or not this Pokémon has multiple forms and can switch between
 *   them.
 * @param growthRate The growth rate for this Pokémon species.
 * @param pokedexNumbers A list of Pokedexes and the indexes reserved within them for this Pokémon
 *   species.
 * @param eggGroups A list of egg groups this Pokémon species is a member of.
 * @param color The color of this Pokémon for Pokedex search.
 * @param shape The shape of this Pokémon for Pokedex search.
 * @param evolvesFromSpecies The Pokémon species that evolves into this one.
 * @param evolutionChain The evolution chain this Pokémon species is a member of.
 * @param habitat The habitat this Pokémon species can be encountered in.
 * @param generation The generation this Pokémon species was introduced in.
 * @param names The name of this Pokémon species listed in different languages.
 * @param palParkEncounters A list of encounters that can be had with this Pokémon species in pal
 *   park.
 * @param formDescriptions The form descriptions for this Pokémon species.
 * @param genera The genera of this Pokémon species listed in multiple languages.
 * @param varieties A list of the Pokémon that exist within this Pokémon species.
 * @param flavorTextEntries A list of flavor text entries for this Pokémon species.
 */
@Serializable
@JsNonWasmExport
public data class PokemonSpecies(
  override val id: Int,
  override val name: String,
  val order: Int,
  val genderRate: Int,
  val captureRate: Int,
  val baseHappiness: Int,
  val isBaby: Boolean,
  val isLegendary: Boolean? = null,
  val isMythical: Boolean? = null,
  val hatchCounter: Int,
  val hasGenderDifferences: Boolean,
  val formsSwitchable: Boolean,
  val growthRate: Handle.Named<GrowthRate>,
  val pokedexNumbers: List<PokemonSpeciesDexEntry>,
  val eggGroups: List<Handle.Named<EggGroup>>,
  val color: Handle.Named<PokemonColor>,
  val shape: Handle.Named<PokemonShape>,
  val evolvesFromSpecies: Handle.Named<PokemonSpecies>?,
  val evolutionChain: Handle.Unnamed<EvolutionChain>,
  val habitat: Handle.Named<PokemonHabitat>?,
  val generation: Handle.Named<Generation>,
  val names: List<Name>,
  val palParkEncounters: List<PalParkEncounterArea>,
  val formDescriptions: List<Description>,
  val genera: List<Genus>,
  val varieties: List<PokemonSpeciesVariety>,
  val flavorTextEntries: List<PokemonSpeciesFlavorText>,
) : NamedModel

/**
 * Flavor text entries for a Pokémon species. See: https://pokeapi.co/docs/v2#flavortext
 *
 * @param flavorText The localized flavor text for a Pokémon species.
 * @param language The language this flavor text is in.
 * @param version The version this flavor text is extracted from.
 */
@Serializable
@JsNonWasmExport
public data class PokemonSpeciesFlavorText(
  val flavorText: String,
  val language: Handle.Named<Language>,
  val version: Handle.Named<Version>,
)

/**
 * The genus of a Pokémon species listed in different languages. See:
 * https://pokeapi.co/docs/v2#genus
 *
 * @param genus The localized genus for a Pokémon species.
 * @param language The language this genus is in.
 */
@Serializable
@JsNonWasmExport
public data class Genus(val genus: String, val language: Handle.Named<Language>)

/**
 * The Pokédex number of a Pokémon species in a specific Pokédex. See:
 * https://pokeapi.co/docs/v2#pokemonspeciesdexentry
 *
 * @param entryNumber The index number within the referenced Pokédex.
 * @param pokedex The Pokédex the referenced Pokémon species can be found in.
 */
@Serializable
@JsNonWasmExport
public data class PokemonSpeciesDexEntry(val entryNumber: Int, val pokedex: Handle.Named<Pokedex>)

/**
 * Areas used for grouping Pokémon encounters in Pal Park. See:
 * https://pokeapi.co/docs/v2#palparkencounterarea
 *
 * @param baseScore The base score given to the player when the referenced Pokémon is caught during
 *   a pal park run.
 * @param rate The base rate for encountering the referenced Pokémon in this pal park area.
 * @param area The pal park area where this encounter happens.
 */
@Serializable
@JsNonWasmExport
public data class PalParkEncounterArea(
  val baseScore: Int,
  val rate: Int,
  val area: Handle.Named<PalParkArea>,
)

/**
 * Pokémon that exist within a species. See: https://pokeapi.co/docs/v2#pokemonspeciesvariety
 *
 * @param isDefault Whether this variety is the default variety.
 * @param variety The Pokémon variety.
 */
@Serializable
@JsNonWasmExport
public data class PokemonSpeciesVariety(
  val isDefault: Boolean,
  @SerialName("pokemon") val variety: Handle.Named<PokemonVariety>,
)

/**
 * Stats determine certain aspects of battles. Each Pokémon has a value for each stat which grows as
 * they gain levels and can be altered momentarily by effects in battles. See:
 * https://pokeapi.co/docs/v2#stats
 *
 * @param id The identifier for this stat resource.
 * @param name The name for this stat resource.
 * @param gameIndex ID the games use for this stat.
 * @param isBattleOnly Whether this stat only exists within a battle.
 * @param affectingMoves A detail of moves which affect this stat and how they affect it.
 * @param affectingNatures A detail of natures which affect this stat and how they affect it.
 * @param characteristics A list of characteristics that are set on a Pokémon when its highest base
 *   stat is this stat.
 * @param moveDamageClass The class of damage this stat is directly related to.
 * @param names The name of this stat listed in different languages.
 */
@Serializable
@JsNonWasmExport
public data class Stat(
  override val id: Int,
  override val name: String,
  val gameIndex: Int,
  val isBattleOnly: Boolean,
  val affectingMoves: MoveStatAffectSets,
  val affectingNatures: NatureStatAffectSets,
  val characteristics: List<Handle.Unnamed<Characteristic>>,
  val moveDamageClass: Handle.Named<MoveDamageClass>?,
  val names: List<Name>,
) : NamedModel

/**
 * A set of moves that affect a stat and how they affect it. See:
 * https://pokeapi.co/docs/v2#movestataffectsets
 *
 * @param increase Moves that increase the stat and by how much.
 * @param decrease Moves that decrease the stat and by how much.
 */
@Serializable
@JsNonWasmExport
public data class MoveStatAffectSets(
  val increase: List<MoveStatAffect>,
  val decrease: List<MoveStatAffect>,
)

/**
 * A move that affects a stat and how it affects it. See: https://pokeapi.co/docs/v2#movestataffect
 *
 * @param change The amount of change to the stat.
 * @param move The move that affects this stat.
 */
@Serializable
@JsNonWasmExport
public data class MoveStatAffect(val change: Int, val move: Handle.Named<Move>)

/**
 * A set of natures that affect a stat and how they affect it. See:
 * https://pokeapi.co/docs/v2#naturestataffectsets
 *
 * @param increase Natures that increase the stat.
 * @param decrease Natures that decrease the stat.
 */
@Serializable
@JsNonWasmExport
public data class NatureStatAffectSets(
  val increase: List<Handle.Named<Nature>>,
  val decrease: List<Handle.Named<Nature>>,
)

/**
 * Types are properties for Pokémon and their moves. Each type has three properties: which types of
 * Pokémon it is super effective against, which types of Pokémon it is not very effective against,
 * and which types of Pokémon it is completely ineffective against. See:
 * https://pokeapi.co/docs/v2#types
 *
 * @param id The identifier for this type resource.
 * @param name The name for this type resource.
 * @param damageRelations A detail of how effective this type is toward others and vice versa.
 * @param pastDamageRelations A list of details of how effective this type was toward others and
 *   vice versa in previous generations.
 * @param gameIndices A list of game indices relevent to this item by generation.
 * @param generation The generation this type was introduced in.
 * @param moveDamageClass The class of damage inflicted by this type.
 * @param names The name of this type listed in different languages.
 * @param pokemon A list of details of Pokémon that have this type.
 * @param moves A list of moves that have this type.
 * @param sprites Sprites for this type.
 */
@Serializable
@JsNonWasmExport
public data class Type(
  override val id: Int,
  override val name: String,
  val damageRelations: TypeRelations,
  val pastDamageRelations: List<TypePastDamageRelation>,
  val gameIndices: List<GenerationGameIndex>,
  val generation: Handle.Named<Generation>,
  val moveDamageClass: Handle.Named<MoveDamageClass>?,
  val names: List<Name>,
  val pokemon: List<TypePokemon>,
  val moves: List<Handle.Named<Move>>,
  val sprites: VersionTypeSprites,
) : NamedModel

@Serializable
@JsNonWasmExport
public data class VersionTypeSprites(
  @SerialName("generation-iii") val generationIii: GenerationIiiTypeSprites,
  @SerialName("generation-iv") val generationIv: GenerationIvTypeSprites,
  @SerialName("generation-v") val generationV: GenerationVTypeSprites,
  @SerialName("generation-vi") val generationVi: GenerationViTypeSprites,
  @SerialName("generation-vii") val generationVii: GenerationViiTypeSprites,
  @SerialName("generation-viii") val generationViii: GenerationViiiTypeSprites,
  @SerialName("generation-ix") val generationIx: GenerationIxTypeSprites,
)

@Serializable
@JsNonWasmExport
public data class GenerationIiiTypeSprites(
  val colosseum: TypeSprites,
  val emerald: TypeSprites,
  @SerialName("firered-leafgreen") val fireredLeafgreen: TypeSprites,
  @SerialName("ruby-sapphire") val rubySaphire: TypeSprites,
  val xd: TypeSprites,
)

@Serializable
@JsNonWasmExport
public data class GenerationIvTypeSprites(
  @SerialName("diamond-pearl") val diamondPearl: TypeSprites,
  @SerialName("heartgold-soulsilver") val heartgoldSoulsilver: TypeSprites,
  val platinum: TypeSprites,
)

@Serializable
@JsNonWasmExport
public data class GenerationVTypeSprites(
  @SerialName("black-2-white-2") val black2White2: TypeSprites,
  @SerialName("black-white") val blackWhite: TypeSprites,
)

@Serializable
@JsNonWasmExport
public data class GenerationViTypeSprites(
  @SerialName("omega-ruby-alpha-sapphire") val omegaRubyAlphaSapphire: TypeSprites,
  @SerialName("x-y") val xY: TypeSprites,
)

@Serializable
@JsNonWasmExport
public data class GenerationViiTypeSprites(
  @SerialName("lets-go-pikachu-lets-go-eevee") val letsGoPikachuLetsGoEevee: TypeSprites,
  @SerialName("sun-moon") val sunMoon: TypeSprites,
  @SerialName("ultra-sun-ultra-moon") val ultraSunUltraMoon: TypeSprites,
)

@Serializable
@JsNonWasmExport
public data class GenerationViiiTypeSprites(
  @SerialName("brilliant-diamond-and-shining-pearl")
  val brilliantDiamondAndShiningPearl: TypeSprites,
  @SerialName("legends-arceus") val legendsArceus: TypeSprites,
  @SerialName("sword-shield") val swordShield: TypeSprites,
)

@Serializable
@JsNonWasmExport
public data class GenerationIxTypeSprites(
  @SerialName("scarlet-violet") val scarletViolet: TypeSprites
)

@Serializable @JsNonWasmExport public data class TypeSprites(val nameIcon: String?)

/**
 * Details of Pokémon that have a specific type. See: https://pokeapi.co/docs/v2#typepokemon
 *
 * @param slot The order the Pokémon's types are listed in.
 * @param pokemon The Pokémon that has this type.
 */
@Serializable
@JsNonWasmExport
public data class TypePokemon(val slot: Int, val pokemon: Handle.Named<PokemonVariety>)

/**
 * A detail of how effective this type is toward others and vice versa. See:
 * https://pokeapi.co/docs/v2#typerelations
 *
 * @param noDamageTo A list of types this type has no effect on.
 * @param halfDamageTo A list of types this type is not very effective against.
 * @param doubleDamageTo A list of types this type is very effective against.
 * @param noDamageFrom A list of types that have no effect on this type.
 * @param halfDamageFrom A list of types that are not very effective against this type.
 * @param doubleDamageFrom A list of types that are very effective against this type.
 */
@Serializable
@JsNonWasmExport
public data class TypeRelations(
  val noDamageTo: List<Handle.Named<Type>>,
  val halfDamageTo: List<Handle.Named<Type>>,
  val doubleDamageTo: List<Handle.Named<Type>>,
  val noDamageFrom: List<Handle.Named<Type>>,
  val halfDamageFrom: List<Handle.Named<Type>>,
  val doubleDamageFrom: List<Handle.Named<Type>>,
)

/**
 * Details of how effective this type was toward others and vice versa in previous generations. See:
 * https://pokeapi.co/docs/v2#typepastdamagerelation
 *
 * @param generation The generation in which the damage relations applied.
 * @param damageRelations The damage relations that applied in the referenced generation.
 */
@Serializable
@JsNonWasmExport
public data class TypePastDamageRelation(
  val generation: Handle.Named<Generation>,
  val damageRelations: TypeRelations,
)
