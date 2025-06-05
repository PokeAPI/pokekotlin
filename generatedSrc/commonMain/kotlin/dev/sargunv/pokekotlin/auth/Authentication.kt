package dev.sargunv.pokekotlin.auth

public interface Authentication {

    /**
     * Apply authentication settings to header and query params.
     *
     * @param query Query parameters.
     * @param headers Header parameters.
     */
    public fun apply(query: MutableMap<String, List<String>>, headers: MutableMap<String, String>)

}
