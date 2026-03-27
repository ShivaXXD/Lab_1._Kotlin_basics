// TODO: Створіть sealed class NetworkResult і два дата-класи: Success та Error, що наслідують його
sealed class NetworkResult

data class Success(val data: String) : NetworkResult()
data class Error(val errorMsg: String) : NetworkResult()