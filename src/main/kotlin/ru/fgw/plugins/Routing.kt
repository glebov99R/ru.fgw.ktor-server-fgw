package ru.fgw.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import ru.fgw.model.Test
import ru.fgw.model.TestD
import java.sql.DriverManager


fun Application.configureRouting() {

    val jdbcUrl = "jdbc:jtds:sqlserver://192.168.0.12:1433;databaseName=AF_Svet_Testing;" // URL-адрес JDBC для подключения к базе данных MS SQL Server
    val dbUser = "oper" // Имя пользователя базы данных
    val dbPassword = "oper" // Пароль базы данных


    // Создание соединения с базой данных
    val connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)

    routing {

        get("/text") {
            call.respond(Test(text = "kitty"))
        }

        get("/sql") {

            val list = mutableListOf<String>()

            // Выполнение запроса
            val statement = connection.createStatement()
            val resultSet = statement.executeQuery("SELECT * FROM svEvents")

            while (resultSet.next()) {
                list.add(resultSet.getString(3))

            }
                call.respond(TestD(textD = list))

            resultSet.close()
            statement.close()
        }

    }

}
