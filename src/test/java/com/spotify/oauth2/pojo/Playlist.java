
package com.spotify.oauth2.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@Getter
@Setter
@Builder
@Jacksonized
@Value
public class Playlist {

    @JsonProperty("collaborative")
    Boolean collaborative;
    @JsonProperty("description")
    String description;
    @JsonProperty("external_urls")
    ExternalUrls externalUrls;
    @JsonProperty("followers")
    Followers followers;
    @JsonProperty("href")
    String href;
    @JsonProperty("id")
    String id;
    @JsonProperty("images")
    List<Object> images = null;
    @JsonProperty("name")
    String name;
    @JsonProperty("owner")
    Owner owner;
    @JsonProperty("primary_color")
    Object primaryColor;
    @JsonProperty("public")
    Boolean _public;
    @JsonProperty("snapshot_id")
    String snapshotId;
    @JsonProperty("tracks")
    Tracks tracks;
    @JsonProperty("type")
    String type;
    @JsonProperty("uri")
    String uri;

    // code is removed to enable lombok

//    @JsonProperty("collaborative")
//    public Boolean getCollaborative() {
//        return collaborative;
//    }
//
//    @JsonProperty("collaborative")
//    public void setCollaborative(Boolean collaborative) {
//        this.collaborative = collaborative;
//    }
//
//    @JsonProperty("description")
//    public String getDescription() {
//        return description;
//    }
//
//    @JsonProperty("description")
//    public Playlist setDescription(String description) {
//        this.description = description;
//        return this;
//    }
//
//    @JsonProperty("external_urls")
//    public ExternalUrls getExternalUrls() {
//        return externalUrls;
//    }
//
//    @JsonProperty("external_urls")
//    public void setExternalUrls(ExternalUrls externalUrls) {
//        this.externalUrls = externalUrls;
//    }
//
//    @JsonProperty("followers")
//    public Followers getFollowers() {
//        return followers;
//    }
//
//    @JsonProperty("followers")
//    public void setFollowers(Followers followers) {
//        this.followers = followers;
//    }
//
//    @JsonProperty("href")
//    public String getHref() {
//        return href;
//    }
//
//    @JsonProperty("href")
//    public void setHref(String href) {
//        this.href = href;
//    }
//
//    @JsonProperty("id")
//    public String getId() {
//        return id;
//    }
//
//    @JsonProperty("id")
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    @JsonProperty("images")
//    public List<Object> getImages() {
//        return images;
//    }
//
//    @JsonProperty("images")
//    public void setImages(List<Object> images) {
//        this.images = images;
//    }
//
//    @JsonProperty("name")
//    public String getName() {
//        return name;
//    }
//
//    @JsonProperty("name")
//    public Playlist setName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    @JsonProperty("owner")
//    public Owner getOwner() {
//        return owner;
//    }
//
//    @JsonProperty("owner")
//    public void setOwner(Owner owner) {
//        this.owner = owner;
//    }
//
//    @JsonProperty("primary_color")
//    public Object getPrimaryColor() {
//        return primaryColor;
//    }
//
//    @JsonProperty("primary_color")
//    public void setPrimaryColor(Object primaryColor) {
//        this.primaryColor = primaryColor;
//    }
//
//    @JsonProperty("public")
//    public Boolean getPublic() {
//        return _public;
//    }
//
//    @JsonProperty("public")
//    public Playlist setPublic(Boolean _public) {
//        this._public = _public;
//        return this;
//    }
//
//    @JsonProperty("snapshot_id")
//    public String getSnapshotId() {
//        return snapshotId;
//    }
//
//    @JsonProperty("snapshot_id")
//    public void setSnapshotId(String snapshotId) {
//        this.snapshotId = snapshotId;
//    }
//
//    @JsonProperty("tracks")
//    public Tracks getTracks() {
//        return tracks;
//    }
//
//    @JsonProperty("tracks")
//    public void setTracks(Tracks tracks) {
//        this.tracks = tracks;
//    }
//
//    @JsonProperty("type")
//    public String getType() {
//        return type;
//    }
//
//    @JsonProperty("type")
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    @JsonProperty("uri")
//    public String getUri() {
//        return uri;
//    }
//
//    @JsonProperty("uri")
//    public void setUri(String uri) {
//        this.uri = uri;
//    }

}
