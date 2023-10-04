package de.robv.android.msposed;

import android.content.res.XResources;

import de.robv.android.msposed.callbacks.XC_InitPackageResources;
import de.robv.android.msposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;

/**
 * Get notified when the resources for an app are initialized.
 * In {@link #handleInitPackageResources}, resource replacements can be created.
 *
 * <p>This interface should be implemented by the module's main class. msposed will take care of
 * registering it as a callback automatically.
 */
public interface msposedHookInitPackageResources extends msposedMod {
    /**
     * This method is called when resources for an app are being initialized.
     * Modules can call special methods of the {@link XResources} class in order to replace resources.
     *
     * @param resparam Information about the resources.
     * @throws Throwable Everything the callback throws is caught and logged.
     */
    void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable;

    /** @hide */
    final class Wrapper extends XC_InitPackageResources {
        private final msposedHookInitPackageResources instance;
        public Wrapper(msposedHookInitPackageResources instance) {
            this.instance = instance;
        }
        @Override
        public void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable {
            instance.handleInitPackageResources(resparam);
        }
    }
}
