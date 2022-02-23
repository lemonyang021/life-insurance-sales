package com.flywolf.li.framework.configcenter.client;

/**
 * 代表配置服务器的节点对象
 * 
 * @author shawn.yang
 *
 */
public class Node implements Comparable<Node> {
  private String url = null;
  private int priority = 1;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  @Override
  public int compareTo(Node o) {
    return this.getPriority() - o.getPriority();
  }

  public Node(String url, int priority) {
    super();
    this.url = url;
    this.priority = priority;
  }

  public Node() {
    super();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((url == null) ? 0 : url.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass()) {
      return false;
    }
    Node other = (Node) obj;
    if (url == null) {
      if (other.url != null) {
        return false;
      }
    } else if (!url.equals(other.url)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Node[url=" + url + ",priority=" + priority + "]";
  }

}
