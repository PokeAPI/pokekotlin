package me.sargunvohra.lib.pokekotlin.model

interface ResourceSummary {
    val id: Int
    val category: String
}

data class ApiResource(
        override val id: Int,
        override val category: String
) : ResourceSummary

data class NamedApiResource(
        override val id: Int,
        override val category: String,
        val name: String
) : ResourceSummary

interface ResourceSummaryList<T : ResourceSummary> {
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