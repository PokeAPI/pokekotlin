package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsOnlyExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@JsOnlyExport
public data class Ability(
  val id: Int,
  val name: String,
  val isMainSeries: Boolean,
  val generation: NamedApiResource,
  val names: List<Name>,
  val effectEntries: List<VerboseEffect>,
  val effectChanges: List<AbilityEffectChange>,
  val flavorTextEntries: List<AbilityFlavorText>,
  val pokemon: List<AbilityPokemon>,
)

@Serializable
@JsOnlyExport
public data class AbilityEffectChange(
  val effectEntries: List<Effect>,
  val versionGroup: NamedApiResource,
)

@Serializable
@JsOnlyExport
public data class AbilityFlavorText(
  val flavorText: String,
  val language: NamedApiResource,
  val versionGroup: NamedApiResource,
)

@Serializable
@JsOnlyExport
public data class AbilityPokemon(
  val isHidden: Boolean,
  val slot: Int,
  val pokemon: NamedApiResource,
)

@Serializable
@JsOnlyExport
public data class Characteristic(
  val id: Int,
  val geneModulo: Int,
  val possibleValues: List<Int>,
  val descriptions: List<Description>,
)

@Serializable
@JsOnlyExport
public data class EggGroup(
  val id: Int,
  val name: String,
  val names: List<Name>,
  val pokemonSpecies: List<NamedApiResource>,
)

@Serializable
@JsOnlyExport
public data class Gender(
  val id: Int,
  val name: String,
  val pokemonSpeciesDetails: List<PokemonSpeciesGender>,
  val requiredForEvolution: List<NamedApiResource>,
)

@Serializable
@JsOnlyExport
public data class PokemonSpeciesGender(val rate: Int, val pokemonSpecies: NamedApiResource)

@Serializable
@JsOnlyExport
public data class GrowthRate(
  val id: Int,
  val name: String,
  val formula: String,
  val descriptions: List<Description>,
  val levels: List<GrowthRateExperienceLevel>,
  val pokemonSpecies: List<NamedApiResource>,
)

@Serializable
@JsOnlyExport
public data class GrowthRateExperienceLevel(val level: Int, val experience: Int)

@Serializable
@JsOnlyExport
public data class Nature(
  val id: Int,
  val name: String,
  val decreasedStat: NamedApiResource?,
  val increasedStat: NamedApiResource?,
  val hatesFlavor: NamedApiResource?,
  val likesFlavor: NamedApiResource?,
  val pokeathlonStatChanges: List<NatureStatChange>,
  val moveBattleStylePreferences: List<MoveBattleStylePreference>,
  val names: List<Name>,
)

@Serializable
@JsOnlyExport
public data class NatureStatChange(val maxChange: Int, val pokeathlonStat: NamedApiResource)

@Serializable
@JsOnlyExport
public data class MoveBattleStylePreference(
  val lowHpPreference: Int,
  val highHpPreference: Int,
  val moveBattleStyle: NamedApiResource,
)

@Serializable
@JsOnlyExport
public data class PokeathlonStat(
  val id: Int,
  val name: String,
  val names: List<Name>,
  val affectingNatures: NaturePokeathlonStatAffectSets,
)

@Serializable
@JsOnlyExport
public data class NaturePokeathlonStatAffectSets(
  val increase: List<NaturePokeathlonStatAffect>,
  val decrease: List<NaturePokeathlonStatAffect>,
)

@Serializable
@JsOnlyExport
public data class NaturePokeathlonStatAffect(val maxChange: Int, val nature: NamedApiResource)

@Serializable
@JsOnlyExport
public data class PokemonVariety(
  val id: Int,
  val name: String,
  val baseExperience: Int,
  val height: Int,
  val isDefault: Boolean,
  val order: Int,
  val weight: Int,
  val species: NamedApiResource,
  val abilities: List<PokemonAbility>,
  val forms: List<NamedApiResource>,
  val gameIndices: List<VersionGameIndex>,
  val heldItems: List<PokemonHeldItem>,
  val moves: List<PokemonMove>,
  val stats: List<PokemonStat>,
  val types: List<PokemonType>,
  val pastTypes: List<PokemonPastType>,
  val pastAbilities: List<PokemonPastAbility>,
  val cries: PokemonCries,
  val sprites: PokemonSprites,
)

@Serializable
@JsOnlyExport
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

@Serializable
@JsOnlyExport
public data class OtherGameSprites(
  val dreamWorld: GameSprites,
  val home: GameSprites,
  @SerialName("official-artwork") val officialArtwork: GameSprites,
  val showdown: GameSprites,
)

@Serializable
@JsOnlyExport
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
@JsOnlyExport
public data class GenerationIGameSprites(
  @SerialName("red-blue") val redBlue: GameSprites,
  val yellow: GameSprites,
)

@Serializable
@JsOnlyExport
public data class GenerationIiGameSprites(
  val crystal: GameSprites,
  val gold: GameSprites,
  val silver: GameSprites,
)

@Serializable
@JsOnlyExport
public data class GenerationIiiGameSprites(
  val emerald: GameSprites,
  @SerialName("firered-leafgreen") val fireredLeafgreen: GameSprites,
  @SerialName("ruby-sapphire") val rubySapphire: GameSprites,
)

@Serializable
@JsOnlyExport
public data class GenerationIvGameSprites(
  @SerialName("diamond-pearl") val diamondPearl: GameSprites,
  @SerialName("heartgold-soulsilver") val heartgoldSoulsilver: GameSprites,
  val platinum: GameSprites,
)

@Serializable
@JsOnlyExport
public data class GenerationVGameSprites(
  @SerialName("black-white") val blackWhite: BlackWhiteSprites
)

@Serializable
@JsOnlyExport
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
@JsOnlyExport
public data class GenerationViGameSprites(
  @SerialName("omegaruby-alphasapphire") val omegaRubyAlphaSapphire: GameSprites,
  @SerialName("x-y") val xY: GameSprites,
)

@Serializable
@JsOnlyExport
public data class GenerationViiGameSprites(
  val icons: GameSprites,
  @SerialName("ultra-sun-ultra-moon") val ultraSunUltraMoon: GameSprites,
)

@Serializable @JsOnlyExport public data class GenerationViiiGameSprites(val icons: GameSprites)

@Serializable
@JsOnlyExport
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

@Serializable
@JsOnlyExport
public data class PokemonAbility(
  val isHidden: Boolean,
  val slot: Int,
  val ability: NamedApiResource?,
)

@Serializable
@JsOnlyExport
public data class PokemonHeldItem(
  val item: NamedApiResource,
  val versionDetails: List<PokemonHeldItemVersion>,
)

@Serializable
@JsOnlyExport
public data class PokemonHeldItemVersion(val version: NamedApiResource, val rarity: Int)

@Serializable
@JsOnlyExport
public data class PokemonMove(
  val move: NamedApiResource,
  val versionGroupDetails: List<PokemonMoveVersion>,
)

@Serializable
@JsOnlyExport
public data class PokemonMoveVersion(
  val moveLearnMethod: NamedApiResource,
  val versionGroup: NamedApiResource,
  val levelLearnedAt: Int,
  val order: Int?,
)

@Serializable
@JsOnlyExport
public data class PokemonStat(val stat: NamedApiResource, val effort: Int, val baseStat: Int)

@Serializable
@JsOnlyExport
public data class PokemonType(val slot: Int, val type: NamedApiResource)

@Serializable
@JsOnlyExport
public data class PokemonPastType(val generation: NamedApiResource, val types: List<PokemonType>)

@Serializable
@JsOnlyExport
public data class PokemonPastAbility(
  val generation: NamedApiResource,
  val abilities: List<PokemonAbility>,
)

@Serializable @JsOnlyExport public data class PokemonCries(val latest: String, val legacy: String?)

@Serializable
@JsOnlyExport
public data class LocationAreaEncounter(
  val locationArea: NamedApiResource,
  val versionDetails: List<VersionEncounterDetail>,
)

@Serializable
@JsOnlyExport
public data class PokemonColor(
  val id: Int,
  val name: String,
  val names: List<Name>,
  val pokemonSpecies: List<NamedApiResource>,
)

@Serializable
@JsOnlyExport
public data class PokemonForm(
  val id: Int,
  val name: String,
  val order: Int,
  val formOrder: Int,
  val isDefault: Boolean,
  val isBattleOnly: Boolean,
  val isMega: Boolean,
  val formName: String,
  val pokemon: NamedApiResource,
  val versionGroup: NamedApiResource,
  val sprites: PokemonFormSprites,
  val types: List<PokemonType>,
  val formNames: List<Name>,
)

@Serializable
@JsOnlyExport
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

@Serializable
@JsOnlyExport
public data class PokemonHabitat(
  val id: Int,
  val name: String,
  val names: List<Name>,
  val pokemonSpecies: List<NamedApiResource>,
)

@Serializable
@JsOnlyExport
public data class PokemonShape(
  val id: Int,
  val name: String,
  val awesomeNames: List<AwesomeName>,
  val names: List<Name>,
  val pokemonSpecies: List<NamedApiResource>,
)

@Serializable
@JsOnlyExport
public data class AwesomeName(val awesomeName: String, val language: NamedApiResource)

@Serializable
@JsOnlyExport
public data class PokemonSpecies(
  val id: Int,
  val name: String,
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
  val growthRate: NamedApiResource,
  val pokedexNumbers: List<PokemonSpeciesDexEntry>,
  val eggGroups: List<NamedApiResource>,
  val color: NamedApiResource,
  val shape: NamedApiResource,
  val evolvesFromSpecies: NamedApiResource?,
  val evolutionChain: ApiResource,
  val habitat: NamedApiResource?,
  val generation: NamedApiResource,
  val names: List<Name>,
  val palParkEncounters: List<PalParkEncounterArea>,
  val formDescriptions: List<Description>,
  val genera: List<Genus>,
  val varieties: List<PokemonSpeciesVariety>,
  val flavorTextEntries: List<PokemonSpeciesFlavorText>,
)

@Serializable
@JsOnlyExport
public data class PokemonSpeciesFlavorText(
  val flavorText: String,
  val language: NamedApiResource,
  val version: NamedApiResource,
)

@Serializable
@JsOnlyExport
public data class Genus(val genus: String, val language: NamedApiResource)

@Serializable
@JsOnlyExport
public data class PokemonSpeciesDexEntry(val entryNumber: Int, val pokedex: NamedApiResource)

@Serializable
@JsOnlyExport
public data class PalParkEncounterArea(
  val baseScore: Int,
  val rate: Int,
  val area: NamedApiResource,
)

@Serializable
@JsOnlyExport
public data class PokemonSpeciesVariety(
  val isDefault: Boolean,
  @SerialName("pokemon") val variety: NamedApiResource,
)

@Serializable
@JsOnlyExport
public data class Stat(
  val id: Int,
  val name: String,
  val gameIndex: Int,
  val isBattleOnly: Boolean,
  val affectingMoves: MoveStatAffectSets,
  val affectingNatures: NatureStatAffectSets,
  val characteristics: List<ApiResource>,
  val moveDamageClass: NamedApiResource?,
  val names: List<Name>,
)

@Serializable
@JsOnlyExport
public data class MoveStatAffectSets(
  val increase: List<MoveStatAffect>,
  val decrease: List<MoveStatAffect>,
)

@Serializable
@JsOnlyExport
public data class MoveStatAffect(val change: Int, val move: NamedApiResource)

@Serializable
@JsOnlyExport
public data class NatureStatAffectSets(
  val increase: List<NamedApiResource>,
  val decrease: List<NamedApiResource>,
)

@Serializable
@JsOnlyExport
public data class Type(
  val id: Int,
  val name: String,
  val damageRelations: TypeRelations,
  val pastDamageRelations: List<TypePastDamageRelation>,
  val gameIndices: List<GenerationGameIndex>,
  val generation: NamedApiResource,
  val moveDamageClass: NamedApiResource?,
  val names: List<Name>,
  val pokemon: List<TypePokemon>,
  val moves: List<NamedApiResource>,
  val sprites: VersionTypeSprites,
)

@Serializable
@JsOnlyExport
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
@JsOnlyExport
public data class GenerationIiiTypeSprites(
  val colosseum: TypeSprites,
  val emerald: TypeSprites,
  @SerialName("firered-leafgreen") val fireredLeafgreen: TypeSprites,
  @SerialName("ruby-saphire") val rubySaphire: TypeSprites,
  val xd: TypeSprites,
)

@Serializable
@JsOnlyExport
public data class GenerationIvTypeSprites(
  @SerialName("diamond-pearl") val diamondPearl: TypeSprites,
  @SerialName("heartgold-soulsilver") val heartgoldSoulsilver: TypeSprites,
  val platinum: TypeSprites,
)

@Serializable
@JsOnlyExport
public data class GenerationVTypeSprites(
  @SerialName("black-2-white-2") val black2White2: TypeSprites,
  @SerialName("black-white") val blackWhite: TypeSprites,
)

@Serializable
@JsOnlyExport
public data class GenerationViTypeSprites(
  @SerialName("omega-ruby-alpha-sapphire") val omegaRubyAlphaSapphire: TypeSprites,
  @SerialName("x-y") val xY: TypeSprites,
)

@Serializable
@JsOnlyExport
public data class GenerationViiTypeSprites(
  @SerialName("lets-go-pikachu-lets-go-eevee") val letsGoPikachuLetsGoEevee: TypeSprites,
  @SerialName("sun-moon") val sunMoon: TypeSprites,
  @SerialName("ultra-sun-ultra-moon") val ultraSunUltraMoon: TypeSprites,
)

@Serializable
@JsOnlyExport
public data class GenerationViiiTypeSprites(
  @SerialName("brilliant-diamond-and-shining-pearl")
  val brilliantDiamondAndShiningPearl: TypeSprites,
  @SerialName("legends-arceus") val legendsArceus: TypeSprites,
  @SerialName("sword-shield") val swordShield: TypeSprites,
)

@Serializable
@JsOnlyExport
public data class GenerationIxTypeSprites(
  @SerialName("scarlet-violet") val scarletViolet: TypeSprites
)

@Serializable @JsOnlyExport public data class TypeSprites(val nameIcon: String?)

@Serializable
@JsOnlyExport
public data class TypePokemon(val slot: Int, val pokemon: NamedApiResource)

@Serializable
@JsOnlyExport
public data class TypeRelations(
  val noDamageTo: List<NamedApiResource>,
  val halfDamageTo: List<NamedApiResource>,
  val doubleDamageTo: List<NamedApiResource>,
  val noDamageFrom: List<NamedApiResource>,
  val halfDamageFrom: List<NamedApiResource>,
  val doubleDamageFrom: List<NamedApiResource>,
)

@Serializable
@JsOnlyExport
public data class TypePastDamageRelation(
  val generation: NamedApiResource,
  val damageRelations: TypeRelations,
)
