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
    val canDelete: Boolean,
    val copyHistory: Array<Post?>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        return copyHistory.contentEquals(other.copyHistory)
    }

    override fun hashCode(): Int {
        return copyHistory.contentHashCode()
    }
}

object WellService {
    private var posts = emptyArray<Post>()
    private var id: Int = 0

    fun add(post: Post): Post {

        posts += post.copy(id = ++id)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var indexBool: Boolean = false
        for ((index, nextPost) in posts.withIndex())
            if (nextPost.id == post.id) { //проверяем что id текущего поста равен нужному/ если равны, просто заменяем пост в массиве
                posts[index] = post.copy()
                indexBool = true
            }
        return indexBool
    }

    fun printArrayPosts() {
        for (i in posts.indices) {
            println(posts[i])
        }
    }

    fun clear() {
        posts = emptyArray()
        id = 0
    }
}

interface Attachment{
    val type: String
}


data class Photo(
    val id: Int,
    val ownerId: Int,
    val photo130: String,
    val photo604: String
)

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val duration: Int
)

data class VideoAttachment(override val type: String = "video", val video: Video): Attachment

data class PhotoAttachment(override val type: String = "photo", val photo: Photo): Attachment
fun main() {

    val post1 = Post(
        0, 22, 344, 1685810584, "hello Kotlin", true, Comments(count = 100), "post", 99, false, arrayOf(null)
    )
    val post2 = Post(
        2, 77, 6768, 1685810584, "hello Kotlin", true, Comments(count = 121), "post", 99, false, arrayOf(post1)
    )


    var wS: WellService = WellService

    println(wS.add(post1))
    println(wS.add(post1))
    println(wS.add(post1))

    println(wS.update(post2))
    wS.printArrayPosts()

    println(PhotoAttachment("photo", Photo(1,1,"https://vk.com/some_photo_link", "https://vk.com/some_photo_link")))
    println(VideoAttachment("video", Video(1,1,"A Funny Video", 30)))
}