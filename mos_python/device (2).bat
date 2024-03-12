
mosquitto_pub -h localhost -t "device/A" -m "{\"timestamp\":\"2023-12-8\",\"location\":{\"latitude\":\"30\",\"longitude\":\"120\"},\"status\":\"normal\",\"data\":\"helloA\",\"active\":\"yes\"}"

mosquitto_pub -h localhost -t "device/A" -m "{\"timestamp\":\"2023-12-1\",\"location\":{\"latitude\":\"120\",\"longitude\":\"120\"},\"status\":\"normal\",\"data\":\"helloA\",\"active\":\"yes\"}"

mosquitto_pub -h localhost -t "device/A" -m "{\"timestamp\":\"2023-11-25\",\"location\":{\"latitude\":\"30\",\"longitude\":\"120\"},\"status\":\"normal\",\"data\":\"helloA\",\"active\":\"yes\"}"
