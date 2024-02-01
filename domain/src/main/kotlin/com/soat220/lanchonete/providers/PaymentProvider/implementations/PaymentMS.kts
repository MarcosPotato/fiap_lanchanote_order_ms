package com.soat220.lanchonete.providers.PaymentProvider.implementations

import com.soat220.lanchonete.providers.PaymentProvider.models.IPaymentProvider
import java.net.HttpURLConnection
import java.net.URL

@Named
class PaymentMS(): IPaymentProvider {
    private fun createPayment(order: Order, paymentStatus: PaymentStatus, totalAmount: Double): Result<Payment, DomainException> {
        val url = "url do ms de pagamento"
        val conn = URL(url).openConnection() as HttpURLConnection

        with(conn) {
            requestMethod = method
            doOutput = body != null
            headers?.forEach(this::setRequestProperty)
        }

        if (body != null) {
            conn.outputStream.use {
                it.write(body.toByteArray())
            }
        }

        val responseBody = conn.inputStream.use { it.readBytes() }.toString(Charsets.UTF_8)

        return Response(conn.responseCode, conn.headerFields, responseBody)
    }
}