package me.sargunvohra.lib.pokekotlin.model

interface ResourceSummary {
    val id: Int
    val category: String
}

data class ApiResource(
        override val category: String,
        override val id: Int
) : ResourceSummary

data class NamedApiResource(
        val name: String,
        override val category: String,
        override val id: Int
) : ResourceSummary

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