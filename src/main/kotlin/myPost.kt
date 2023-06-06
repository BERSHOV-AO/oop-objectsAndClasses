package ru.netology

data class Comments(
    val count: Int,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = false,
    val canOpen: Boolean = true
)

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val friendsOnly: Boolean,
    val comments: Comments,
    val postType: String,
    val signerId: Int,
    val canDelete: Boolean
)

object WellService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }
}

fun main() {

    val post1 = Post(
        1, 22, 344, 1685810584, "hello Kotlin", true, Comments(count = 100), "post", 99, false
    )

    println(post1)
}