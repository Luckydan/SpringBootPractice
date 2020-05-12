package com.luckydan.springbootssm.basic;

import lombok.Data;

/**
 * @author gl
 */
@Data
public class IdParams extends BaseParams
{
  private static final long serialVersionUID = 1L;
  private SearchParams params;
}