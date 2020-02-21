import 'dart:async';

import 'package:flutter/services.dart';

class ToastPlugin {
  static const MethodChannel _channel =
      const MethodChannel('toast_plugin');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  ///args 参数可以在这里面传递
  static Future<Null> getToast({args}) async {
    await _channel.invokeMethod('getToast',args);
    return null;
  }

}
