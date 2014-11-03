function DevisesIncompatibleExc(_d1,_d2) {
    this.d1=_d1;
    this.d2=_d2;
}

DevisesIncompatibleExc.prototype.toString = function () {
    return "Devises incompatibles : " + this.d1 + " vs " + this.d2;
}

function SoustractionIncompatibleExc(_d1,_d2) {
    this.d1=_d1;
    this.d2=_d2;

}

SoustractionIncompatibleExc.prototype.toString=function (){
    return "Soustraction exception : "+this.d1+" vs "+this.d2;
}

function CurrNotFound() {


}

CurrNotFound.prototype.toString = function () {
    return "Curr not found exception";
}