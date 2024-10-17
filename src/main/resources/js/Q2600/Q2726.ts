class Calculator {
    _value: number | undefined

    constructor(value: number) {
        this._value = value
    }

    add(value: number): Calculator {
        return new Calculator(this._value + value)
    }

    subtract(value: number): Calculator {
        return new Calculator(this._value - value)
    }

    multiply(value: number): Calculator {
        return new Calculator(this._value * value)
    }

    divide(value: number): Calculator {
        if (value === 0) {
            throw new Error("Division by zero is not allowed")
        }
        return new Calculator(this._value / value)
    }

    power(value: number): Calculator {
        return new Calculator(Math.pow(this._value, value))
    }

    getResult(): number {
        return this._value
    }
}
