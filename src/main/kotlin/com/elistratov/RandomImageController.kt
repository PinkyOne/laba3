package com.elistratov

import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import java.awt.image.BufferedImage
import java.util.*
import javax.imageio.ImageIO
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "image", value = "/image.jpg")
class RandomImageController : HttpServlet() {
    override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
        res.contentType = "image/jpg"

        var image = BufferedImage(600, 200, BufferedImage.TYPE_3BYTE_BGR)
        drawHello(image.createGraphics())

        ImageIO.write(image, "jpg", res.outputStream)
    }

    fun drawHello(graphics: Graphics) {
        var (R, G, B) = getRGB()
        System.out.println("r:" + R.toString() + " g:" + G.toString() + " b:" + B.toString())
        var font = Font("Times New Roman", Font.BOLD, 72)
        graphics.fillRect(0, 0, 1000, 1000)
        graphics.color = Color(R, G, B)
        graphics.font = font
        graphics.drawString("Hello World!", 100, 100)
    }

    private fun getRGB(): Triple<Int, Int, Int> {
        val random = Random(Date().time)
        var R = random.nextInt(256)
        var G = random.nextInt(256)
        var B = random.nextInt(256)
        return Triple(R, G, B)
    }
}