package com.glima.ilovecats.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asFlow
import androidx.lifecycle.liveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.glima.domain.business.model.BreedImage
import com.glima.domain.business.usecase.LoadRandomImageForBreedingUseCase
import com.glima.ilovecats.BreedVO
import com.glima.ilovecats.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BreedDetailViewModelTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()
    private val testDispatcher = TestCoroutineDispatcher()


    @MockK
    lateinit var useCase: LoadRandomImageForBreedingUseCase

    lateinit var viewModel: BreedDetailViewModel


    private val breeVO = BreedVO(
        id = "abys",
        name = "Abyssinian",
        intelligence = 5,
        affectionLevel = 5,
        isRare = true,
        lifeSpan = "immortal",
        description = "cute cat breed <3"
    )

    private val breedImage = BreedImage(
        id = "1234",
        url = "some_url"
    )

    @Before
    fun setupTestEnvironment() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)


        viewModel = BreedDetailViewModel(
            loadRandomImageUseCase = useCase,
            breedVO = breeVO
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun loadImage_loadsNewRandomBreedImage() = testDispatcher.runBlockingTest {
        coEvery { useCase.execute(breeVO.id) } returns liveData { emit(breedImage) }.asFlow()
//        when
        viewModel.loadImage()
//        then
        val value = viewModel.image.getOrAwaitValue()
        assertEquals(value, breedImage)
    }
}
