package com.tocura.study.kotlin.adapter.controller.exception

import com.tocura.study.kotlin.adapter.controller.exception.response.ErrorResponse
import com.tocura.study.kotlin.exceptions.TrainerNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandlerController {

    @ExceptionHandler
    fun trainerNotFound(e: TrainerNotFoundException): ResponseEntity<ErrorResponse> {
        val errResponse = ErrorResponse(
            HttpStatus.NOT_FOUND.toString(),
            e.message.toString(),
            e.cause.toString(),
        )
        return ResponseEntity(errResponse, HttpStatus.NOT_FOUND)
    }
}