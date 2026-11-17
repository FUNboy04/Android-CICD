package com.example.navigationexample

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Student(
    val id: Int,
    val fullName: String,
    val academicMajor: String,
    val biography: String,
    val emailAddress: String,
    val currentGpa: Double,
    @DrawableRes val imageResId: Int,
    val themeColor: Color
)

object StudentRepository {
    val studentList = listOf(
        Student(
            id = 101,
            fullName = "Red Ruin Joni",
            academicMajor = "Computer Science",
            biography = "She is passionate about mobile app development, artificial intelligence, and open-source software. Currently working on a cross-platform navigation framework project.",
            emailAddress = "jonir1@montclair.edu",
            currentGpa = 3.85,
            imageResId = R.drawable.imgjoni,
            themeColor = Color(0xFF1E88E5)
        ),
        Student(
            id = 102,
            fullName = "Philip Graves",
            academicMajor = "Electrical Engineering",
            biography = "He specializes in embedded systems and robotics. President of the University Robotics Club and a hobbyist hardware hacker.",
            emailAddress = "gravesp5@montclair.edu",
            currentGpa = 3.92,
            imageResId = R.drawable.imgphilipgraves,
            themeColor = Color(0xFF43A047)
        ),
        Student(
            id = 103,
            fullName = "Roxanne Wolf",
            academicMajor = "Digital Art & U.I. Design",
            biography = "She is an U.I. enthusiast who loves crafting intuitive user interfaces. Enjoys digital illustration, 3-D modeling, and interactive media prototyping.",
            emailAddress = "wolfr2@montclair.edu",
            currentGpa = 3.74,
            imageResId = R.drawable.imgroxy,
            themeColor = Color(0xFF8E24AA)
        ),
        Student(
            id = 104,
            fullName = "Porsha Crystal",
            academicMajor = "Cognitive Psychology",
            biography = "She is a research assistant studying human-computer interaction and memory retention. Plans to pursue a Ph.D in Cognitive Science.",
            emailAddress = "crystalp3@montclair.edu",
            currentGpa = 3.98,
            imageResId = R.drawable.imgporsha,
            themeColor = Color(0xFFE53935)
        ),
        Student(
            id = 105,
            fullName = "Rozlin Helms",
            academicMajor = "Business Analytics",
            biography = "She is a data-driven thinker focused on financial technology and market trends. Team leader for the annual Campus Tech Start-Up Challenge.",
            emailAddress = "helmsr1@montclair.edu",
            currentGpa = 3.68,
            imageResId = R.drawable.imgroze,
            themeColor = Color(0xFFFB8C00)
        ),
        Student(
            id = 106,
            fullName = "Bardon Schaeffer",
            academicMajor = "Biomedical Science",
            biography = "He is a Pre-med student researching gene editing techniques. Active volunteer at local community health clinics and science outreach mentor.",
            emailAddress = "schaefferb1@montclair.edu",
            currentGpa = 3.91,
            imageResId = R.drawable.imgbardon,
            themeColor = Color(0xFF00ACC1)
        )
    )

    fun getStudentById(id: Int?): Student? {
        if (id == null) return null
        return studentList.find { it.id == id }
    }
}
