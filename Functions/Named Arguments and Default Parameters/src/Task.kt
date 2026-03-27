fun createWindow(width: Int = 800, height: Int = 600, title: String = "Untitled"): String {
    return "Window '$title' [$width x $height]"
}

fun openApp(): String {
    // TODO: Викличте createWindow, передавши лише title = "My App"
    return createWindow(title = "My App")
}