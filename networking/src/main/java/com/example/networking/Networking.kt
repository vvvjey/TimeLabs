package com.example.networking

import org.w3c.dom.TypeInfo

interface Networking {
    suspend fun <R : Any, T : Any> get(
        encodedPath: String,
        headers: Map<String, Any> = emptyMap(),
        parameters: Map<String, Any>,
        typeInfo: TypeInfo
    ): R

    suspend fun <R : Any, T : Any> post(
        encodedPath: String,
        header: Map<String, Any> = emptyMap(),
        request: R,
        response: T
    ): R

    suspend fun <R : Any, T : Any> put(
        encodedPath: String,
        header: Map<String, Any> = emptyMap(),
        request: R,
        response: T
    ): R

    suspend fun <R : Any, T : Any> delete(
        encodedPath: String,
        header: Map<String, Any> = emptyMap(),
        request: R,
        response: T
    ): R
}