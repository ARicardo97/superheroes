package com.superheroes.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Comics {
    @SerializedName("available")
    @Expose
    var available: Int? = null

    @SerializedName("collectionURI")
    @Expose
    var collectionURI: String? = null

    @SerializedName("items")
    @Expose
    var items: List<Item>? = null

    @SerializedName("returned")
    @Expose
    var returned: Int? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param collectionURI
     * @param available
     * @param returned
     * @param items
     */
    constructor(
        available: Int?,
        collectionURI: String?,
        items: List<Item>?,
        returned: Int?
    ) : super() {
        this.available = available
        this.collectionURI = collectionURI
        this.items = items
        this.returned = returned
    }
}