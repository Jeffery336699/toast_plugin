#import "ToastPlugin.h"
#import <toast_plugin/toast_plugin-Swift.h>

@implementation ToastPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftToastPlugin registerWithRegistrar:registrar];
}
@end
