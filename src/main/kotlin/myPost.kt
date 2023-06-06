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
    private var id: Int = 1

    fun add(post: Post): Post {

        if (posts.isEmpty()) {
            posts += post.copy(id = id)
            id++
        } else {
            posts += post.copy(id = id)
            id++
        }
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var indexBool: Boolean = false
        for ((index, nextPost) in posts.withIndex())
            if (nextPost.id == post.id) { //проверяем что id текущего поста равен нужному/ если равны, просто заменяем пост в массиве
                posts[index] = post
                indexBool = true
            }
        return indexBool
    }

    fun getArrayPosts(){
        for (i in posts.indices) {
            println(posts[i])
        }
    }
}


fun main() {

    val post1 = Post(
        0, 22, 344, 1685810584, "hello Kotlin", true, Comments(count = 100), "post", 99, false
    )
    val post2 = Post(
        2, 77, 6768, 1685810584, "hello Kotlin", true, Comments(count = 121), "post", 99, false
    )


    var wS: WellService = WellService

    println(wS.add(post1))
    println(wS.add(post1))
    println(wS.add(post1))

    println( wS.update(post2))
    wS.getArrayPosts()


}