package com.jeffery.study.toast_plugin

import android.content.Context
import android.widget.Toast
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar
class ToastPlugin(private val context: Context) : MethodCallHandler {

  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar) {
      val channel = MethodChannel(registrar.messenger(), "toast_plugin")
//        context从这里面获取
      channel.setMethodCallHandler(ToastPlugin(registrar.context()))
    }
  }

  override fun onMethodCall(call: MethodCall, result: Result) {
//      调用方法的判断
    when (call.method) {
        "getPlatformVersion" -> {
          result.success("Android ${android.os.Build.VERSION.RELEASE}")
        }
        "getToast" -> {
//            参数接收在这里面接收
          val text = call.argument<String>("text")
          Toast.makeText(context,text,Toast.LENGTH_SHORT).show()
        }
        else -> {
          result.notImplemented()
        }
    }
  }
}
