trait Cache[K,V] {
  def get(key:K): V
  def put(key:K, value:V)
  def delete(key: K)
  def remove[K](key:K)
}