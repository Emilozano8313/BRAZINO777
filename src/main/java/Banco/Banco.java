package banco;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import banco.Cuenta;

public class Banco {
    private Map<String, Cuenta> cuentas;
    private static final String ARCHIVO_DATOS = "cuentas.dat";

    public Banco(){
        cuentas = new HashMap<>();
        cargarCuentas();
    }
    
    public void crearCuenta(String numeroCuenta, String titular, double saldoInicial) {
        if (cuentas.containsKey(numeroCuenta)){
            throw new IllegalArgumentException("Ya existe cuenta con ese numero");
        }
        Cuenta nuevaCuenta = new Cuenta(numeroCuenta, titular, saldoInicial);
        cuentas.put(numeroCuenta, nuevaCuenta);
        guardarCuentas();
    }

    public void depositar(String numeroCuenta, double monto) {
        Cuenta cuenta = obtenerCuenta(numeroCuenta);
        cuenta.depositar(monto);
        guardarCuentas();
    }

    public void retirar (String numeroCuenta, double monto) {
        Cuenta cuenta = obtenerCuenta(numeroCuenta);
        cuenta.retirar(monto);
        guardarCuentas();
    }

    
}
