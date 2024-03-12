
mosquitto_pub -h localhost -t "device/testapp" -m "{\"timestamp\":\"2023-12-10\",\"location\":{\"latitude\":\"90\",\"longitude\":\"10\"},\"status\":\"normal\",\"data\":\"helloA\",\"active\":\"no\"}"

mosquitto_pub -h localhost -t "device/testapp" -m "{\"timestamp\":\"2023-12-13\",\"location\":{\"latitude\":\"40\",\"longitude\":\"60\"},\"status\":\"normal\",\"data\":\"helloA\",\"active\":\"no\"}"

mosquitto_pub -h localhost -t "device/testapp" -m "{\"timestamp\":\"2023-12-15\",\"location\":{\"latitude\":\"30\",\"longitude\":\"120\"},\"status\":\"normal\",\"data\":\"helloA\",\"active\":\"yes\"}"


mosquitto_pub -h localhost -t "device/testapp" -m "{\"timestamp\":\"2023-12-20\",\"location\":{\"latitude\":\"90\",\"longitude\":\"10\"},\"status\":\"normal\",\"data\":\"helloA\",\"active\":\"no\"}"

mosquitto_pub -h localhost -t "device/testapp" -m "{\"timestamp\":\"2023-12-18\",\"location\":{\"latitude\":\"40\",\"longitude\":\"60\"},\"status\":\"normal\",\"data\":\"helloA\",\"active\":\"no\"}"

mosquitto_pub -h localhost -t "device/testapp" -m "{\"timestamp\":\"2023-12-5\",\"location\":{\"latitude\":\"30\",\"longitude\":\"120\"},\"status\":\"normal\",\"data\":\"helloA\",\"active\":\"yes\"}"