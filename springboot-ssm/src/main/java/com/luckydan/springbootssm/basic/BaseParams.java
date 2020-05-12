package com.luckydan.springbootssm.basic;

import lombok.Data;
import java.io.Serializable;

/**
 * @author gl
 */
@Data
public class BaseParams implements Serializable
{
  private static final long serialVersionUID = 1L;

  private String id;
}
