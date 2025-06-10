import PokeKotlinDemoApp
import SwiftUI
import UIKit

struct MainView: UIViewControllerRepresentable {
  func makeUIViewController(context: Context) -> UIViewController {
    MainViewControllerKt.MainViewController()
  }

  func updateUIViewController(
    _ uiViewController: UIViewController, context: Context
  ) {}
}

@main
struct iOSApp: App {
  var body: some Scene {
    WindowGroup {
      MainView()
        // Compose modifiers
        .ignoresSafeArea(.keyboard)
        .ignoresSafeArea(edges: .all)
    }
  }
}
