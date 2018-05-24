function check(){
    let a = 'a';
    let b = 'b';
    let p = ' ';
    let test = document.getElementById('test');
    let test1 = document.getElementById('test1');

    if(test.value.substr(0,1) === test1.value.substr(0,1)){
        test.value = test.value.substr(1,test.value.length);
        test1.value = '';
        let k = parseInt(getRandomArbitrary(1,4));
        if(k === 1){
            test.value += a;
        } else if(k === 2){
            test.value += b;
        }else {
            test.value += p;
        }
    }

}

function getRandomArbitrary(min, max) {
    return Math.random() * (max - min) + min;
}

// function test(){
//     alert("Hello"); // added sample text
// }