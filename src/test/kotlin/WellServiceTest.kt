import org.junit.Test

import org.junit.Assert.*
import ru.netology.Comments
import ru.netology.Post

class WellServiceTest {

    @Test
    fun addTest() {
        val post1 = Post(
            0, 22, 344, 1685810584, "hello Kotlin", true, Comments(count = 100), "post", 99, false
        )

    }

    @Test
    fun updateTest() {
    }
}