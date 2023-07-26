package com.LV.myapplication

class Nequi {
}

fun main() {
    var contador=3
    var opcion1: String = "no"
    var opcion: Int = 0
    var numeroTelefono: Long = 3013519220
    var contraseña: Long = 2265
    var saldo = 4500
    var enviarUsu = mutableListOf<Long>(3251419123, 3143025234, 3133480690, 3011011256)
    var nombre = mutableListOf<String>("Jimena", "Sofia", "Luciana", "Hasbleidy")
    var apellido = mutableListOf("Perez", "Matalocas", "Paris", "Mursia")
    var codConfirmacion: Int = (1000..9999).random()

    fun sacarPlata(sacar1: Int) {
        saldo = saldo - sacar1
        println("Su saldo quedó en: $saldo")
    }

    fun enviarPlata(cantEnviar: Int) {
        saldo = saldo - cantEnviar
        println("El saldo acutual es: $saldo")

    }

    fun recargarPlata(recargar: Int) {
        saldo = recargar + saldo
        println("El saldo actual es: $saldo")
    }

    while (contador!=0){
        println("Bienvenido al servidor de Nequi")
        println("Para ingresar, por favor digite lo siguiente")
        println("Ingrese su número de teléfono:")
        var num = readLine()!!.toLong()
        println("Ingrese su contraseña:")
        var pass = readLine()!!.toLong()


        if (num == numeroTelefono && pass == contraseña) {
            while (opcion1 == "no") {
                println("Bienvenido, se ha ingresado a la plataforma con éxito")
                println("Su saldo es: $saldo")
                println("Escoja lo que quiere realizar:")
                println("1. Sacar plata")
                println("2. Enviar plata")
                println("3. Recargar plata")
                println("4. Salir de la plataforma")

                opcion = readLine()!!.toInt()

                if (opcion == 1) {
                    println("has escogido la opcion sacar plata ")
                    println("su saldo actual es: $saldo")


                    if (saldo >= 2000) {
                        println("cuanto desea sacar?")
                        var sacar1 = readLine()!!.toInt()

                        if (sacar1 < saldo) {
                            println("aahora te vamos a enviar un codigo de confirmacion ")
                            println(codConfirmacion)
                            println("digita el codigo de confirmacion")
                            var coden = readln()!!.toInt()

                            if (codConfirmacion == coden) {
                                println("Retiro exitoso")
                                sacarPlata(sacar1)
                            }

                        } else {
                            println("usted no cuenta con el saldo suficiente")
                        }

                    } else {
                        println("Lo siento no tiene el saldo suficiente")
                    }


                } else if (opcion == 2) {
                    println("Usted ha escogido la opción de enviar plata")
                    println("Digite el número del usuario a quien le quiere enviar la plata")
                    var numUsu = readLine()!!.toLong()

                    if (saldo >= 2000) {
                        println("Digite la cantidad a enviar")
                        var cantEnviar = readLine()!!.toInt()
                        val index = enviarUsu.indexOf(numUsu)

                        if (index != -1) {
                            val numUsuario = enviarUsu[index]
                            val nombreUsuario = nombre[index]
                            val apellidoUsuario = apellido[index]
                            println("Numero: $numUsuario")
                            println("Nombre: $nombreUsuario")
                            println("Apellido: $apellidoUsuario")
                            println("Cantidad: $cantEnviar")
                            println("Si quiere enviar digite enviar de lo contrario digite cancelar")
                            var opcionEnviar = readLine().toString().toLowerCase()
                            if (opcionEnviar == "enviar") {
                                println("El envio fue exitoso gracias por utilizar nequi")
                                enviarPlata(cantEnviar)
                            } else {
                                println("Has canselado el envio")
                            }
                        } else {
                            println("El número de teléfono ingresado no coincide con ningún usuario.")
                        }
                    } else {
                        println("lo siento no tiene el saldo suficiente")
                    }


                } else if (opcion == 3) {
                    println("Has escogido la opcion de recargar")
                    println("El saldo disponible actualmente es: $saldo")
                    println("Cuanto desea recargar")
                    var recargar = readLine()!!.toInt()
                    println("Si desea recargar digite recargar  y si no digite cancelar")
                    var recarga1 = readln()!!.toString().lowercase()
                    if (recarga1 == "recargar") {
                        println("La recarga fue exitosa")
                        println(recargarPlata(recargar))
                    } else {
                        println("Usted a cancelado la recarga")
                    }
                }

            }
            println("quieres salir de nuestra plataforma?")
            println("si lo deseas digite si de lo contrario digite no")
            opcion1 = readln()!!.toString().lowercase()
        }
        else {
            println("los datos son incorrectos, por lo tanto no se puede ingresar a la plataforma")
            contador=contador-1
            println("son: $contador")
        }

    }
}