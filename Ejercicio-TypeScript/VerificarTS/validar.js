var MiPrimeraClase = /** @class */ (function () {
    function MiPrimeraClase(_nombre) {
        this.minombre = _nombre;
    }
    MiPrimeraClase.prototype.MiPrimeraFuncion = function () {
        var saludo = "Hola, ".concat(this.minombre, ", esta es mi primera clase y funci\u00F3n en typescript!");
        console.log(saludo);
    };
    return MiPrimeraClase;
}());
var miPrimerObjeto = new MiPrimeraClase("soy Juliana");
miPrimerObjeto.MiPrimeraFuncion();
