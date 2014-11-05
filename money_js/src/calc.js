function calc() {
        this.message="";
}

calc.prototype.displayResult=function (resultDiv) {
            resultDiv.innerHTML=this.message;
            
        };
        
calc.prototype.computeResult=function (form) {
            //alert("Not the same currency");

            //display a alert if the value of a money is < 0
            if(parseInt(form.elements['v1'].value) < 0 || parseInt(form.elements['v2'].value) < 0 ){
                window.alert('Money cant be less then 0');
                //in this case we should stop the calculation
                return;
            }

            //display a alert if the currency is not the same
            if(form.elements['c1'].value != form.elements['c2'].value){
                window.alert('Not the same currency');
                //in this case we should stop the calculation
                return;
            }



            m1=new money(parseInt(form.elements['v1'].value),
                            form.elements['c1'].value);
            m2=new money(parseInt(form.elements['v2'].value),
                            form.elements['c2'].value);
                            
            ops=form.elements['ops'].value;
	    
            try{
                if (ops==="ADD") {
                    res=MoneyOps.add(m1,m2);
                    this.message="Result : "+(res.toString())+"";
                
                }
                else if(ops==="SUB"){
                    res=MoneyOps.soustraction(m1,m2);
                    this.message="Result : "+(res.toString())+"";
                }

                else {
                    this.message="Unsupported operation "+ops+"";
                    window.alert('Unsupported operation');
                }
            }catch (e) {
                this.message=e.toString();



            }
	};

function doComputation(form,resDiv) {
    c=new calc();
    c.computeResult(form);
    c.displayResult(resDiv);
}
