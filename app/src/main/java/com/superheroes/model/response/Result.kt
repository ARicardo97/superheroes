package com.superheroes.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("modified")
    @Expose
    var modified: String? = null

    @SerializedName("thumbnail")
    @Expose
    var thumbnail: Thumbnail? = null

    @SerializedName("resourceURI")
    @Expose
    var resourceURI: String? = null

    @SerializedName("comics")
    @Expose
    var comics: Comics? = null

    @SerializedName("series")
    @Expose
    var series: Series? = null

    @SerializedName("stories")
    @Expose
    var stories: Stories? = null

    @SerializedName("events")
    @Expose
    var events: Events? = null

    @SerializedName("urls")
    @Expose
    var urls: List<Url>? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param thumbnail
     * @param urls
     * @param stories
     * @param series
     * @param comics
     * @param name
     * @param description
     * @param modified
     * @param id
     * @param resourceURI
     * @param events
     */
    constructor(
        id: Int?,
        name: String?,
        description: String?,
        modified: String?,
        thumbnail: Thumbnail?,
        resourceURI: String?,
        comics: Comics?,
        series: Series?,
        stories: Stories?,
        events: Events?,
        urls: List<Url>?
    ) : super() {
        this.id = id
        this.name = name
        this.description = description
        this.modified = modified
        this.thumbnail = thumbnail
        this.resourceURI = resourceURI
        this.comics = comics
        this.series = series
        this.stories = stories
        this.events = events
        this.urls = urls
    }
}