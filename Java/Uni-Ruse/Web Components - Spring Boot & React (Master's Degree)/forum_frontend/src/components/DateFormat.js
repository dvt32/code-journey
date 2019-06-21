import React from 'react'

export default (props) => {
  return <div>
    {(new Date(props.date)).toLocaleDateString('bg-BG')} {(new Date(props.date)).toLocaleTimeString('bg-BG')}
  </div>
}
