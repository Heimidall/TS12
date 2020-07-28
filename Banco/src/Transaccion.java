import java.util.ArrayList;
import java.util.List;

public class Transaccion {
    private int saldoPesos;
    private int saldoDolares;
    private final int saldoDolaresMaximo;
    private final int saldoPesosMaximo;
    private int operaciones;
    List<String> historial;



    public Transaccion() {
        this.saldoPesos = 1000000;
        this.saldoDolares = 1000;
        this.saldoDolaresMaximo = 100;
        this.saldoPesosMaximo = 200000;
        this.operaciones = 4;
        this.historial = new ArrayList<>();
        this.historial.add("");
        this.historial.add("");
        this.historial.add("1000000, CLP, 1000, USD");

    }

    public int getOperaciones() {
        return operaciones;
    }
    public int getSaldoPesos() {
        return saldoPesos;
    }

    public int getSaldoDolar() {
        return saldoDolares;
    }
    public void retirarSaldo(String Formato) throws Exception {
        try {
            String[] arrFormat = Formato.split(" ",2);
            String curr = arrFormat[0];
            int dinero = Integer.parseInt(arrFormat[1]);
            if (curr.equals("USD")) {
                if((this.saldoDolares - dinero) < 0 || dinero < 0 || dinero > this.saldoDolaresMaximo){
                    throw new Exception("Error con la operación intente nuevamente");
                }
                else{
                    this.saldoDolares -= dinero;
                    addHistorial(String.format("%s, CLP, %s, USD",this.saldoPesos,this.saldoDolares));
                    usoSesion();
                }
            }
            else if (curr.equals("CLP")) {
                if((this.saldoPesos - dinero < 0) || dinero < 0 || dinero > this.saldoPesosMaximo){
                    throw new Exception("Error con la operación intente nuevamente");
                }
                else{
                    this.saldoPesos -= dinero;
                    addHistorial(String.format("%s, CLP, %s, USD",this.saldoPesos,this.saldoDolares));
                    usoSesion();
                }
            }else{
                throw new Exception("Error en la operacion intente nuevamente");
            }
        }catch (Exception e){
            throw new Exception("Error con la operación intente nuevamente");

        }
    }

    public void depositarSaldo(String Formato) throws Exception {
        try {
            String[] arrFormat = Formato.split(" ", 2);
            String curr = arrFormat[0];
            int dinero = Integer.parseInt(arrFormat[1]);
            if (curr.equals("USD") && dinero >= 0) {
                this.saldoDolares += dinero;
                addHistorial(String.format("%s, CLP, %s, USD",this.saldoPesos,this.saldoDolares));
                usoSesion();
            }
            else if(curr.equals("CLP") && dinero >= 0) {
                this.saldoPesos += dinero;
                addHistorial(String.format("%s, CLP, %s, USD", this.saldoPesos, this.saldoDolares));
                usoSesion();
            }else{
                throw new Exception("El formato que ingresó no es correcto");
            }
        }catch (Exception e){
            throw new Exception("El formato que ingresó no es correcto");
        }
    }

    public void usoSesion() throws Exception {
        if(this.operaciones > 0){
            this.operaciones -= 1;
        }
        else{
            throw new Exception("La sesión ha expirado");
        }
    }

    public List<String> getHistorial() {
        int size = this.historial.size();
        return this.historial.subList(size-3,size);
    }

    public void addHistorial(String transac) {
        this.historial.add(transac);
    }
}
