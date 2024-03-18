package com.genius.notessql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.genius.notessql.databinding.ActivityAddNoteBinding
import com.genius.notessql.databinding.ActivityMainBinding

private lateinit var binding: ActivityAddNoteBinding

private lateinit var db:NotesDatabaseHelper

class AddNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title = binding.titleEditNext.text.toString()
            val content = binding.contentEditText.text.toString()
            val  note = Note(0, title, content)
            db.insertNote(note)
            finish()

            Toast.makeText(this, "Note saved", Toast.LENGTH_LONG).show()
        }


    }
}