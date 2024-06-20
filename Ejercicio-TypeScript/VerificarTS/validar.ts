class MiPrimeraClase {
    minombre: string;

    constructor(_nombre: string) {
        this.minombre = _nombre;
    }
    MiPrimeraFuncion(): void {
        let saludo = `Hola, ${this.minombre}, esta es mi primera clase y función en typescript!`;
        console.log(saludo);
    }
}

const miPrimerObjeto = new MiPrimeraClase("soy Juliana");

miPrimerObjeto.MiPrimeraFuncion();