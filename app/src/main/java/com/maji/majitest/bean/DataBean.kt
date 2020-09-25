package com.maji.majitest.bean

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

/**
 * {
current_user_url: "https://api.github.com/user",
current_user_authorizations_html_url: "https://github.com/settings/connections/applications{/client_id}",
authorizations_url: "https://api.github.com/authorizations",
code_search_url: "https://api.github.com/search/code?q={query}{&page,per_page,sort,order}",
commit_search_url: "https://api.github.com/search/commits?q={query}{&page,per_page,sort,order}",
emails_url: "https://api.github.com/user/emails",
emojis_url: "https://api.github.com/emojis",
events_url: "https://api.github.com/events",
feeds_url: "https://api.github.com/feeds",
followers_url: "https://api.github.com/user/followers",
following_url: "https://api.github.com/user/following{/target}",
gists_url: "https://api.github.com/gists{/gist_id}",
hub_url: "https://api.github.com/hub",
issue_search_url: "https://api.github.com/search/issues?q={query}{&page,per_page,sort,order}",
issues_url: "https://api.github.com/issues",
keys_url: "https://api.github.com/user/keys",
label_search_url: "https://api.github.com/search/labels?q={query}&repository_id={repository_id}{&page,per_page}",
notifications_url: "https://api.github.com/notifications",
organization_url: "https://api.github.com/orgs/{org}",
organization_repositories_url: "https://api.github.com/orgs/{org}/repos{?type,page,per_page,sort}",
organization_teams_url: "https://api.github.com/orgs/{org}/teams",
public_gists_url: "https://api.github.com/gists/public",
rate_limit_url: "https://api.github.com/rate_limit",
repository_url: "https://api.github.com/repos/{owner}/{repo}",
repository_search_url: "https://api.github.com/search/repositories?q={query}{&page,per_page,sort,order}",
current_user_repositories_url: "https://api.github.com/user/repos{?type,page,per_page,sort}",
starred_url: "https://api.github.com/user/starred{/owner}{/repo}",
starred_gists_url: "https://api.github.com/gists/starred",
user_url: "https://api.github.com/users/{user}",
user_organizations_url: "https://api.github.com/user/orgs",
user_repositories_url: "https://api.github.com/users/{user}/repos{?type,page,per_page,sort}",
user_search_url: "https://api.github.com/search/users?q={query}{&page,per_page,sort,order}"
}
 */
@DatabaseTable(tableName = "data_bean")//table name
data class DataBean(
    @DatabaseField(generatedId = true)//id自增长，如果自己设定id的话，就是generatedId = true
    var id: Int = 0,
    @DatabaseField(columnName = "authorizations_url")
    val authorizations_url: String? = null,
    @DatabaseField(columnName = "code_search_url")
    val code_search_url: String? = null,
    @DatabaseField(columnName = "commit_search_url")
    val commit_search_url: String? = null,
    @DatabaseField(columnName = "current_user_authorizations_html_url")
    val current_user_authorizations_html_url: String? = null,
    @DatabaseField(columnName = "current_user_repositories_url")
    val current_user_repositories_url: String? = null,
    @DatabaseField(columnName = "current_user_url")
    val current_user_url: String? = null,
    @DatabaseField(columnName = "emails_url")
    val emails_url: String? = null,
    @DatabaseField(columnName = "emojis_url")
    val emojis_url: String? = null,
    @DatabaseField(columnName = "events_url")
    val events_url: String? = null,
    @DatabaseField(columnName = "feeds_url")
    val feeds_url: String? = null,
    @DatabaseField(columnName = "followers_url")
    val followers_url: String? = null,
    @DatabaseField(columnName = "following_url")
    val following_url: String? = null,
    @DatabaseField(columnName = "gists_url")
    val gists_url: String? = null,
    @DatabaseField(columnName = "hub_url")
    val hub_url: String? = null,
    @DatabaseField(columnName = "issue_search_url")
    val issue_search_url: String? = null,
    @DatabaseField(columnName = "issues_url")
    val issues_url: String? = null,
    @DatabaseField(columnName = "keys_url")
    val keys_url: String? = null,
    @DatabaseField(columnName = "label_search_url")
    val label_search_url: String? = null,
    @DatabaseField(columnName = "notifications_url")
    val notifications_url: String? = null,
    @DatabaseField(columnName = "organization_repositories_url")
    val organization_repositories_url: String? = null,
    @DatabaseField(columnName = "organization_teams_url")
    val organization_teams_url: String? = null,
    @DatabaseField(columnName = "organization_url")
    val organization_url: String? = null,
    @DatabaseField(columnName = "public_gists_url")
    val public_gists_url: String? = null,
    @DatabaseField(columnName = "rate_limit_url")
    val rate_limit_url: String? = null,
    @DatabaseField(columnName = "repository_search_url")
    val repository_search_url: String? = null,
    @DatabaseField(columnName = "repository_url")
    val repository_url: String? = null,
    @DatabaseField(columnName = "starred_gists_url")
    val starred_gists_url: String? = null,
    @DatabaseField(columnName = "starred_url")
    val starred_url: String? = null,
    @DatabaseField(columnName = "user_organizations_url")
    val user_organizations_url: String? = null,
    @DatabaseField(columnName = "user_repositories_url")
    val user_repositories_url: String? = null,
    @DatabaseField(columnName = "user_search_url")
    val user_search_url: String? = null,
    @DatabaseField(columnName = "user_url")
    val user_url: String? = null
)