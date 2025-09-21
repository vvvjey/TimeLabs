package com.example.networking

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.http.encodedPath
import org.w3c.dom.TypeInfo
import kotlin.reflect.KClass
import kotlin.reflect.KType

class NetworkingImpl(
    private val httpClient : HttpClient
) : Networking {
    override suspend fun <R : Any, T : Any> get(
        encodedPath: String,
        headers: Map<String, Any>,
        parameters: Map<String, Any>,
        typeInfo: TypeInfo
    ): R {
//        val builder = HttpRequestBuilder().apply {
//            url {
//                this.encodedPath = encodedPath
//            }
//            parameters.forEach { (key, value) -> parameter(key, value) }
//            headers { headers.forEach { (key, value) -> header(key, value) } }
//        }
//        return httpClient.get(builder).call.body(typeInfo) as T
        TODO("Not yet implemented")

    }

    override suspend fun <R : Any, T : Any> post(
        encodedPath: String,
        header: Map<String, Any>,
        request: R,
        response: T
    ): R {
        TODO("Not yet implemented")
    }

    override suspend fun <R : Any, T : Any> put(
        encodedPath: String,
        header: Map<String, Any>,
        request: R,
        response: T
    ): R {
        TODO("Not yet implemented")
    }

    override suspend fun <R : Any, T : Any> delete(
        encodedPath: String,
        header: Map<String, Any>,
        request: R,
        response: T
    ): R {
        TODO("Not yet implemented")
    }

}
internal fun <T : Any> createTypeInfo(objInfo: ObjectInfo<T>): io.ktor.util.reflect.TypeInfo {
//    return io.ktor.util.reflect.TypeInfo(
//        objInfo.kClass,
//        objInfo.kType.platformType,
//        objInfo.kType
//    )
    TODO("Not yet implemented")

}
class ObjectInfo<T : Any>(
    val kClass: KClass<T>,
    val kType: KType
)
