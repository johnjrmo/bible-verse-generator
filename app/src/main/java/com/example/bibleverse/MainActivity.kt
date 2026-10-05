package com.example.bibleverse

import android.app.Activity
import android.os.Bundle
import com.example.bibleverse.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : Activity() {
    private lateinit var binding: ActivityMainBinding
    private var lastReference = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.newVerseButton.setOnClickListener { showRandomReference() }
        showRandomReference()
    }

    private fun showRandomReference() {
        var reference: String
        do {
            val book = BibleIndex.books.random()
            val chapter = Random.nextInt(book.chapterCount) + 1
            val verseCount = book.getVerseCount(chapter)
            val verse = if (verseCount > 0) Random.nextInt(verseCount) + 1 else 1
            reference = "${book.name} $chapter:$verse"
        } while (reference == lastReference)
        lastReference = reference
        binding.verseReference.text = reference
    }
}
