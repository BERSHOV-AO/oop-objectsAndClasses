import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import ru.netology.Comments
import ru.netology.Post
import ru.netology.WellService
import ru.netology.WellService.add
import ru.netology.WellService.update

class WellServiceTest {

    @Test
    fun addTest() {
        val post1 = Post(
            0, 22, 344, 1685810584, "hello Kotlin", true, Comments(count = 100), "post", 99, false, arrayOf(null)

        )
        var valueId = add(post1).id
        assertEquals(1, valueId)
    }

    @Test
    fun updateTestSuccess() {
        val post1 = Post(
            0, 22, 344, 1685810584, "hello Kotlin", true, Comments(count = 100), "post", 99, false, arrayOf(null)
        )
        val post2 = Post(
            2, 77, 6768, 1685810584, "hello Kotlin", true, Comments(count = 121), "post", 99, false, arrayOf(post1)
        )
        add(post1)
        add(post1)
        add(post1)

        val flagBool: Boolean = update(post2)
        assertTrue(flagBool)
    }

    @Before
    fun clearBeforeTest() {
        WellService.clear()
    }

    @Test
    fun updateTestFailed() {
        val post1 = Post(
            0, 22, 344, 1685810584, "hello Kotlin", true, Comments(count = 100), "post", 99, false, arrayOf(null)
        )
        val post4 = Post(
            4, 77, 6768, 1685810584, "hello Kotlin", true, Comments(count = 121), "post", 99, false, arrayOf(post1)
        )
        add(post1)
        add(post1)
        add(post1)

        val flagBool: Boolean = update(post4)
        assertFalse(flagBool)
    }
}