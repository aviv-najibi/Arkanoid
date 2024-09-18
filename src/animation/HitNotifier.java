package animation;
/**
 * name: aviv najibi
 * ID: 314621699
 * class name: HitNotifier
 * class explain: The HitNotifier interface represents an object that can notify listeners of hit events.
 * It defines methods to add and remove HitListeners from its list of listeners.
 */
public interface HitNotifier {
  /**
   * Adds the specified HitListener to the list of listeners to hit events.
   *
   * @param hl The HitListener to be added.
   */
  void addHitListener(HitListener hl);
  /**
   * Removes the specified HitListener from the list of listeners to hit events.
   *
   * @param hl The HitListener to be removed.
   */
  void removeHitListener(HitListener hl);
}
