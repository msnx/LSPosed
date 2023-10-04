package org.lsposed.lspd.hooker;

import android.app.ActivityThread;

import de.robv.android.msposed.msposedInit;
import io.github.libxposed.api.XposedInterface;
import io.github.libxposed.api.annotations.AfterInvocation;
import io.github.libxposed.api.annotations.XposedHooker;

@XposedHooker
public class AttachHooker implements XposedInterface.Hooker {

    @AfterInvocation
    public static void afterHookedMethod(XposedInterface.AfterHookCallback callback) {
        msposedInit.loadModules((ActivityThread) callback.getThisObject());
    }
}
