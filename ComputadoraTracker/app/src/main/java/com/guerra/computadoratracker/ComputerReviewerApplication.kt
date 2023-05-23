package com.guerra.computadoratracker

import android.app.Application
import com.guerra.computadoratracker.data.model.computers
import com.guerra.computadoratracker.repository.Repository

class ComputerReviewerApplication: Application() {

    val computerRepository: Repository by lazy {
        Repository(computers)
    }
}