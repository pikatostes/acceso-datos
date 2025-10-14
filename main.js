const fibonacci = (n) => {
    let a = 0, b = 1, c = 0;

    for (let i = 0; i < n; i++) {
        c = a + b;
        a = b;
        b = c;
        console.log(c)
    }
}

fibonacci(10);